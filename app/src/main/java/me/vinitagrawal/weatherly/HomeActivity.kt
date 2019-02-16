package me.vinitagrawal.weatherly

import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import me.vinitagrawal.weatherly.core.BaseActivity
import me.vinitagrawal.weatherly.model.WeatherInfo
import me.vinitagrawal.weatherly.viewmodel.WeatherViewModel

class HomeActivity : BaseActivity<WeatherViewModel>(WeatherViewModel::class.java) {

    private val temperature by lazy { findViewById<TextView>(R.id.tvTemperature) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        observeWeather()
    }

    private fun observeWeather() {
        viewModel.getWeatherInfo().observe(this,
            Observer<WeatherInfo> { weatherInfo ->
                weatherInfo?.let {
                    temperature.text = it.temperatureInfo.temp.toString()
                }
            })
    }
}