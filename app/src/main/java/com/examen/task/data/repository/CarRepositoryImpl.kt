package com.examen.task.data.repository

import com.examen.task.data.datasource.CarDataSource
import com.examen.task.data.model.Cars
import com.examen.task.domain.repository.CarRepository
import javax.inject.Inject

class CarRepositoryImpl @Inject constructor(private val carDataSource: CarDataSource): CarRepository {

    override suspend fun getCarList(): MutableList<Cars> {
        return carDataSource.getCarList()
    }
}