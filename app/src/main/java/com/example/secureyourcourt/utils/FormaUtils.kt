package com.example.secureyourcourt.utils


import java.text.NumberFormat
import java.util.Locale

fun formatPrecio(precio: Int): String {
    val formato = NumberFormat.getNumberInstance(Locale("es", "CL"))
    return "$" + formato.format(precio.toInt())
}
