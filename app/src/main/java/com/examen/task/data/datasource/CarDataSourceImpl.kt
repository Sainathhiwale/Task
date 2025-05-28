package com.examen.task.data.datasource

import com.examen.task.data.model.Cars
import com.examen.task.data.remote.api.ApiService
import javax.inject.Inject

class CarDataSourceImpl @Inject constructor(private val apiService: ApiService): CarDataSource {

    override suspend fun getCarList(): MutableList<Cars> {
        return apiService.getCarList()
    }
}