package com.examen.task.presentation.di

import com.examen.task.domain.repository.CarRepository
import com.examen.task.domain.usecase.CarUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CarUseCaseModule {

    @Singleton
    @Provides
    fun provideCarUseCase(carRepository: CarRepository): CarUseCase {
        return CarUseCase(carRepository)
    }
}