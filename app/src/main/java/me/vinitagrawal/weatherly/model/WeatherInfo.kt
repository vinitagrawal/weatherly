package me.vinitagrawal.weatherly.model

import com.google.gson.annotations.SerializedName

data class WeatherInfo(@SerializedName("weather") val weather: List<Weather>,
                       @SerializedName("main") val temperatureInfo: TemperatureInfo,
                       @SerializedName("wind") val wind: Wind,
                       @SerializedName("dt") val date: Long,
                       @SerializedName("id") val infoId: Int,
                       @SerializedName("name") val cityName: String)

data class Wind(@SerializedName("speed") val speed: Double,
                @SerializedName("deg") val degree: Int)

data class Weather(@SerializedName("id") val id: Int,
                   @SerializedName("main") val type: String,
                   @SerializedName("description") val description: String,
                   @SerializedName("icon") val icon: String)

data class TemperatureInfo(@SerializedName("temp") val temp: Double,
                           @SerializedName("pressure") val pressure: Int,
                           @SerializedName("humidity") val humidity: Int,
                           @SerializedName("temp_min") val temp_min: Double,
                           @SerializedName("temp_max") val temp_max: Double)
