package com.example.secureyourcourt.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.secureyourcourt.model.ClimaResponse
import com.example.secureyourcourt.repository.ClimaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ClimaViewModel : ViewModel() {

    private val repository = ClimaRepository()
    private val _clima = MutableStateFlow<ClimaResponse?>(null)
    val clima: StateFlow<ClimaResponse?> = _clima

    fun cargarClima(lat: Double, lon: Double, apiKey: String) {
        viewModelScope.launch {
            try {
                val data = repository.getClima(lat, lon, apiKey)
                _clima.value = data
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
