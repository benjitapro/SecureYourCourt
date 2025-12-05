package com.example.secureyourcourt.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.secureyourcourt.model.Carrito
import com.example.secureyourcourt.model.Cancha
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

/**
 * CarritoViewModel:
 * - mantiene compatibilidad con el carrito de canchas (items)
 * - añade manejo de "jugadores" como lista de IDs (1,2,3...) expuesta como StateFlow
 *
 * Los nombres de jugadores NO se guardan aquí (según tu solicitud).
 */
class CarritoViewModel : ViewModel() {

    val items = mutableStateListOf<Carrito>()

    fun agregarAlCarrito(cancha: Cancha) {
        val existente = items.find { it.cancha.id == cancha.id }
        if (existente != null) {
            existente.cantidad += 1
        } else {
            items.add(Carrito(cancha))
        }
    }

    fun eliminarDelCarrito(item: Carrito) {
        items.remove(item)
    }

    fun actualizarCantidad(item: Carrito, cantidad: Int) { // No se usara aun
        if (cantidad <= 0) {
            eliminarDelCarrito(item)
        } else {
            val index = items.indexOf(item)
            if (index != -1) items[index].cantidad = cantidad
        }
    }

    fun total(): Int {
        return items.sumOf { it.cancha.precioHora * it.cantidad }
    }

    fun vaciarCarrito() {
        items.clear()
    }

    //MANEJO DE JUGADORES
    private val _jugadores = MutableStateFlow<List<Int>>(emptyList())
    val jugadores: StateFlow<List<Int>> = _jugadores.asStateFlow()


    //Agrega un jugador nuevo con id ascendente
    fun agregarJugador() {
        val current = _jugadores.value.toMutableList()
        if (current.size >= 22) return
        val nextId = (current.size + 1)
        current.add(nextId)
        _jugadores.value = current
    }

    // Elimina el último jugador
    fun eliminarJugador() {
        val current = _jugadores.value.toMutableList()
        if (current.isNotEmpty()) {
            current.removeLast()
            _jugadores.value = current
        }
    }

    //Vacía la lista de jugadores como despues de confirmar reserva
    fun vaciarJugadores() {
        _jugadores.value = emptyList()
    }
}