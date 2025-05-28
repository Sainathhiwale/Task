package com.examen.task.presentation.di

import com.examen.task.data.datasource.CarDataSource
import com.examen.task.data.repository.CarRepositoryImpl
import com.examen.task.domain.repository.CarRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository(carDataSource: CarDataSource): CarRepository {
        return CarRepositoryImpl(carDataSource)
    }

}