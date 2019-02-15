package me.vinitagrawal.weatherly.repository

import me.vinitagrawal.weatherly.api.WeatherService
import me.vinitagrawal.weatherly.model.WeatherInfo
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call

@RunWith(MockitoJUnitRunner::class)
class WeatherRepositoryImplTest {

    @Mock
    private lateinit var weatherService: WeatherService
    @Mock
    private lateinit var call: Call<WeatherInfo>

    private lateinit var weatherRepository: WeatherRepository

    @Before
    fun setUp() {
        weatherRepository = WeatherRepositoryImpl(weatherService)
    }

    @Test
    fun `should fetch weather info`() {
        `when`(weatherService.getWeatherForCity("London")).thenReturn(call)

        weatherRepository.getWeatherForCity()

        verify(weatherService).getWeatherForCity("London")
    }
}