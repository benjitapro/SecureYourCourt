package com.example.secureyourcourt.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import com.example.secureyourcourt.model.Cancha
import com.example.secureyourcourt.repository.CanchaRepository
import kotlinx.coroutines.launch

class CanchasViewModel : ViewModel()  {

    // Inicializar el repositorio
    private val repository = CanchaRepository()

    val canchas = mutableStateOf<List<Cancha>>(emptyList())
    val loading = mutableStateOf(true)
    val error = mutableStateOf<String?>(null)

    init {
        cargarCanchas()
    }

    fun cargarCanchas() {
        viewModelScope.launch {
            try {
                val data = repository.cargarCanchas()
                canchas.value = data
                loading.value = false
                error.value = null
            } catch (e: Exception) {
                error.value = "Error al cargar canchas: ${e.message}"
                loading.value = false
            }
        }
    }
}