package com.example.secureyourcourt.repository


import com.example.secureyourcourt.network.RetrofitClientClima

class ClimaRepository {

    suspend fun getClima(lat: Double, lon: Double, apiKey: String) =
        RetrofitClientClima.api.obtenerClima(
            lat = lat,
            lon = lon,
            units = "metric",
            lang = "es",
            apiKey = apiKey
        )
}