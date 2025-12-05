package com.example.secureyourcourt.model


data class ClimaResponse(
    val weather: List<WeatherInfo>,
    val main: MainInfo,
    val name: String
)

data class WeatherInfo(
    val description: String
)

data class MainInfo(
    val temp: Double,
    val humidity: Int
)