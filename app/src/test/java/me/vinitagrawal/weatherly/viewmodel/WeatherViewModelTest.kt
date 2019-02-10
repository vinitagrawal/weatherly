package me.vinitagrawal.weatherly.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class WeatherViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var weatherViewModel: WeatherViewModel

    @Before
    fun setUp() {
        weatherViewModel = WeatherViewModel()
    }

    @Test
    fun `should return weather info`() {
        assertEquals("10°C",weatherViewModel.getWeatherInfo().value?.temperature)
    }
}