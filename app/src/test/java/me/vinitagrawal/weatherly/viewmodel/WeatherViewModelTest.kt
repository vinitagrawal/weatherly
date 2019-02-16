package me.vinitagrawal.weatherly.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import me.vinitagrawal.weatherly.getFileFromPath
import me.vinitagrawal.weatherly.model.WeatherInfo
import me.vinitagrawal.weatherly.read
import me.vinitagrawal.weatherly.repository.WeatherRepository
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers.any
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@RunWith(MockitoJUnitRunner::class)
class WeatherViewModelTest {

    @get:Rule
    val taskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repo: WeatherRepository
    @Mock
    private lateinit var call: Call<WeatherInfo>

    private lateinit var viewModel: WeatherViewModel

    @Before
    fun setUp() {
        viewModel = WeatherViewModel(repo)
    }

    @After
    fun tearDown() {
        verifyNoMoreInteractions(repo, call)
    }

    @Test
    fun `should return weather info`() {
        val weatherInfo = createWeatherInfo()
        `when`(repo.getWeatherForCity()).thenReturn(call as Call<WeatherInfo>?)

        `when`(call.enqueue(any()))
            .then { invocation ->
                val callback = invocation.arguments[0] as Callback<WeatherInfo>
                callback.onResponse(call, Response.success(weatherInfo))
            }

        viewModel.onRender()

        assertEquals("London", viewModel.weatherInfo.value?.cityName)
        verify(repo).getWeatherForCity()
        verify(call).enqueue(any())
    }

    private fun createWeatherInfo() =
        getFileFromPath("london_weather_info.json")
            .read(WeatherInfo::class.java)
}