package com.examen.task.presentation.di

import com.examen.task.data.datasource.CarDataSource
import com.examen.task.data.datasource.CarDataSourceImpl
import com.examen.task.data.remote.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Singleton
    @Provides
    fun provideDataSource(apiService: ApiService): CarDataSource {
      return CarDataSourceImpl(apiService)
    }
}