package com.examen.task.domain.usecase

import com.examen.task.data.model.Cars
import com.examen.task.domain.repository.CarRepository
import javax.inject.Inject

class CarUseCase @Inject constructor(private val carRepository: CarRepository) {

    suspend fun getCarList():MutableList<Cars>{
        return carRepository.getCarList()
    }
}