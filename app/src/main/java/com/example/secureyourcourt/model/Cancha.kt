package com.example.secureyourcourt.model
//lol
data class Cancha(
    val id: Int,
    val nombre: String,
    val tipoSuperficie: String,
    val dimensiones: String,
    val medidas: String,
    val jugadores: String,
    val descripcion: String?,
    val ubicacion: String,
    val precioHora: Int,
    val imagen: String
)