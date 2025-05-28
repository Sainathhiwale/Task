package com.examen.task.presentation.di

import com.examen.task.domain.usecase.CarUseCase
import com.examen.task.presentation.viewmodel.CarViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class CarViewModule {

    @Singleton
    @Provides
    fun provideCarView(carUseCase: CarUseCase): CarViewModel {
        return CarViewModel(carUseCase)
    }

}