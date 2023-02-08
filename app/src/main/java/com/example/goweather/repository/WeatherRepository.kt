package com.example.goweather.repository

import android.util.Log
import com.example.goweather.data.DataOrException
import com.example.goweather.model.Weather
import com.example.goweather.model.WeatherObject
import com.example.goweather.network.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val api: WeatherApi) {
    suspend fun getWeather(longitude: String, latitude: String)
    :DataOrException<Weather, Boolean, Exception> {
        val response = try {
            api.getWeather(longitude = longitude, latitude = latitude)
        } catch (e: Exception){
            Log.d("Exception", "getWeather: $e")
            return DataOrException(e = e)
        }
        Log.d("INSIDE", "getWeather: $response")
        return DataOrException(data = response)
    }
}