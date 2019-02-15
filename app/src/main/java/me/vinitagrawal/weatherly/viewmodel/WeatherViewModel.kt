package me.vinitagrawal.weatherly.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import me.vinitagrawal.weatherly.model.WeatherInfo
import me.vinitagrawal.weatherly.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel(private val weatherRepository: WeatherRepository) : ViewModel() {

    private var weatherInfo: MutableLiveData<WeatherInfo> = MutableLiveData()

    fun getWeatherInfo(): LiveData<WeatherInfo> {
        loadWeather()
        return weatherInfo
    }

    private fun loadWeather() {
        weatherRepository.getWeatherForCity().enqueue(object : Callback<WeatherInfo> {
            override fun onFailure(call: Call<WeatherInfo>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<WeatherInfo>, response: Response<WeatherInfo>) {
                if (response.isSuccessful)
                    weatherInfo.value = response.body()

            }
        })
    }
}