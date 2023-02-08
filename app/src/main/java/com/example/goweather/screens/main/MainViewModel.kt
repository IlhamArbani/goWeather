package com.example.goweather.screens.main

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.goweather.data.DataOrException
import com.example.goweather.model.Weather
import com.example.goweather.model.WeatherObject
import com.example.goweather.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: WeatherRepository)
    :ViewModel(){
    suspend fun getWeatherData(longitude: String, latitude: String)
    : DataOrException<Weather, Boolean, Exception>{
        return repository.getWeather(longitude, latitude)
    }

}