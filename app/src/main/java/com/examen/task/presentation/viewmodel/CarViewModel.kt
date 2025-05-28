package com.examen.task.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.examen.task.data.model.Cars
import com.examen.task.data.utils.Resources
import com.examen.task.domain.usecase.CarUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CarViewModel @Inject constructor (private val carUseCase: CarUseCase): ViewModel() {

    private var _cars = MutableStateFlow<Resources<Cars>>(Resources.Loading())
    val cars:StateFlow<Resources<Cars>> = _cars

    fun getCars() {
        viewModelScope.launch {
           getCarInFlow().collect { response ->
               _cars.value = response

           }
        }
    }

    private fun getCarInFlow(): Flow<Resources<Cars>> = flow{
         emit(Resources.Loading())
          try {
              val response = withContext(Dispatchers.IO){
                carUseCase.getCarList()
              }
          }catch (e:Exception){
              emit(Resources.Error(e.message.toString()))
          }
    }
}