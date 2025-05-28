package com.examen.task.data.remote.api

import com.examen.task.data.model.Cars
import retrofit2.http.GET

interface ApiService {

    @GET("carlist")
    suspend fun getCarList():MutableList<Cars>
}