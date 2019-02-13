package me.vinitagrawal.weatherly.repository

import androidx.annotation.VisibleForTesting
import me.vinitagrawal.weatherly.api.WeatherService
import me.vinitagrawal.weatherly.model.WeatherInfo
import me.vinitagrawal.weatherly.network.NetworkFactory
import retrofit2.Call

interface WeatherRepository {
    fun getWeatherForCity(): Call<WeatherInfo>
}

class WeatherRepositoryImpl : WeatherRepository {

    private var weatherService: WeatherService = NetworkFactory().getService(WeatherService::class.java)

    @VisibleForTesting
    fun setWeatherService(service: WeatherService) {
        weatherService = service
    }

    override fun getWeatherForCity(): Call<WeatherInfo> {
        return weatherService.getWeatherForCity("London")
    }

}