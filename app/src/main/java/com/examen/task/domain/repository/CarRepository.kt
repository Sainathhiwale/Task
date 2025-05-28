package com.examen.task.domain.repository

import com.examen.task.data.model.Cars

interface CarRepository {

    suspend fun getCarList():MutableList<Cars>
}