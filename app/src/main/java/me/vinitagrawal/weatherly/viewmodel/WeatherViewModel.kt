package me.vinitagrawal.weatherly.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.vinitagrawal.weatherly.model.WeatherInfo

class WeatherViewModel : ViewModel() {

    private var weatherInfo: MutableLiveData<WeatherInfo> = MutableLiveData()

    init {
        weatherInfo = weatherInfo.apply {
            value = WeatherInfo("10°C")
        }
    }

    fun getWeatherInfo(): LiveData<WeatherInfo> {
        return weatherInfo
    }
}