package me.vinitagrawal.weatherly.repository

import me.vinitagrawal.weatherly.api.WeatherService
import me.vinitagrawal.weatherly.model.WeatherInfo
import retrofit2.Call

interface WeatherRepository {
    fun getWeatherForCity(): Call<WeatherInfo>
}

class WeatherRepositoryImpl(private val weatherService: WeatherService) : WeatherRepository {

    override fun getWeatherForCity(): Call<WeatherInfo> {
        return weatherService.getWeatherForCity("London")
    }

}