package me.vinitagrawal.weatherly

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import me.vinitagrawal.weatherly.model.WeatherInfo
import me.vinitagrawal.weatherly.viewmodel.WeatherViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var weatherViewModel: WeatherViewModel

    private val temperature by lazy { findViewById<TextView>(R.id.tvTemperature) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        weatherViewModel = ViewModelProviders.of(this).get(WeatherViewModel::class.java)

        subscribe()
    }

    private fun subscribe() {
        weatherViewModel.getWeatherInfo().observe(this,
            Observer<WeatherInfo> { weatherInfo ->
                weatherInfo?.let {
                    temperature.text = it.temperatureInfo.temp.toString()
                }
            })
    }
}