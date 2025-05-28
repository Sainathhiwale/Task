package com.examen.task.data.datasource

import com.examen.task.data.model.Cars

interface CarDataSource {

    suspend fun getCarList():MutableList<Cars>
}