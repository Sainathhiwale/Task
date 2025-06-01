package com.examen.task.car_api

import com.examen.task.data.model.Cars
import com.examen.task.data.utils.Resources
import com.examen.task.domain.usecase.CarUseCase
import com.examen.task.presentation.viewmodel.CarViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock

@ExperimentalCoroutinesApi
class CarViewModelTest {

    private lateinit var carViewModel: CarViewModel
    private val carUseCase: CarUseCase = mock()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setup() {
        carViewModel = CarViewModel(carUseCase)
    }

    @Test
    fun `getCars should emit success`() = runTest {
        val dummyList = listOf(Cars(id = 1, name = "Tesla", brand = "Tesla", price = 1000, image_url = ""))

        carViewModel.getCars()
        val result = carViewModel.cars.first { it is Resources.Success }

        assertTrue(result is Resources.Success)
        assertEquals(dummyList, (result as Resources.Success).data)
    }
}
