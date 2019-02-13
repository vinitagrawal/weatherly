package me.vinitagrawal.weatherly.api

import me.vinitagrawal.weatherly.model.WeatherInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {

    @GET(WEATHER_INFO)
    fun getWeatherForCity(@Query(QUERY_KEY_CITY) city: String,
                          @Query(QUERY_KEY_APP_ID) appId: String = ""): Call<WeatherInfo>

    companion object {
        const val WEATHER_INFO = "2.5/weather"

        private const val QUERY_KEY_CITY = "q"
        private const val QUERY_KEY_APP_ID = "appid"
    }
}