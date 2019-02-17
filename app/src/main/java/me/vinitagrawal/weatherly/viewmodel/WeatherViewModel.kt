package me.vinitagrawal.weatherly.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import me.vinitagrawal.weatherly.core.BaseViewModel
import me.vinitagrawal.weatherly.model.WeatherInfo
import me.vinitagrawal.weatherly.repository.WeatherRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel(private val weatherRepository: WeatherRepository) : BaseViewModel() {

    var weatherInfo: MutableLiveData<WeatherInfo> = MutableLiveData()

    override fun onRender() {
        fetchWeather()
    }

    private fun fetchWeather() {
        weatherRepository.getWeatherForCity().enqueue(object : Callback<WeatherInfo> {
            override fun onFailure(call: Call<WeatherInfo>, t: Throwable) {
                Log.d(javaClass.simpleName, t.message)
            }

            override fun onResponse(call: Call<WeatherInfo>, response: Response<WeatherInfo>) {
                if (response.isSuccessful)
                    weatherInfo.value = response.body()
            }
        })
    }
}