package com.examen.task.car_api

import com.examen.task.data.remote.api.ApiService
import com.examen.task.data.utils.AppConstants
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CarApiTest {

    private lateinit var mockWebServer: MockWebServer
    private lateinit var api: ApiService

    @Before
    fun setup() {
        mockWebServer = MockWebServer()
        api = Retrofit.Builder()
            .baseUrl(mockWebServer.url("/carlist"))
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(AppConstants.TESTING_URL)
            .build()
            .create(ApiService::class.java)
    }

    @Test
    fun `getCars should return car list`() = runBlocking {
        val mockResponse = MockResponse()
            .setResponseCode(200)
            .setBody("""
                [
                  {
                    "id":1,
                    "name":"Tesla",
                    "brand":"Tesla",
                    "price":1000,
                    "image_url":""
                  }
                ]
            """.trimIndent())

        mockWebServer.enqueue(mockResponse)

        val result = api.getCarList()
        assertEquals(1, result.size)
        assertEquals("Tesla", result[0].name)
    }

    @After
    fun tearDown() {
        mockWebServer.shutdown()
    }
}
