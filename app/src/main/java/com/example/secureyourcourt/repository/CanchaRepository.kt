package com.example.secureyourcourt.repository

import com.example.secureyourcourt.model.Cancha
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.delay

class CanchaRepository {

    private val gson = Gson()
    // Datos de canchas cargados directamente del archivo assets/Canchas.json
    private val canchasJson = """
[
  {
    "id": 1,
    "nombre": "Cancha Futbol 11",
    "tipoSuperficie": "Pasto Sintético 3ra generacion de alta durabilidad.",
    "dimensiones": "La cancha cuenta con 120 metros de largo por 90 metros de ancho.",
    "medidas": "Cada arco cuenta con 7.30 metros de ancho por 2.45 metros de alto.",
    "jugadores": "La capacidad para la cancha son de 22 jugadores.",
    "descripcion": "Cancha de Futbol 11, Pasto Sintético.",
    "ubicacion": "C. Diecinueve A 1066, Peñalolén",
    "precioHora": 55600.0,
    "imagen": "futbol"
  },
  {
    "id": 2,
    "nombre": "Cancha Futbol 7",
    "tipoSuperficie": "Pasto Sintético 3ra generacion de alta durabilidad.",
    "dimensiones": "60 metros el largo por 40 metros de ancho.",
    "medidas": "Cada arco cuenta con 3.30 metros de ancho por 2.15 metros de alto.",
    "jugadores": "Maximo son 14 jugadores en cancha 7 por cada lado",
    "descripcion": "Una cancha a nivel competitivo ideal para torneos de alto rendimiento.",
    "ubicacion": "Francisco de Villagra 6581, La reina",
    "precioHora": 15000.0,
    "imagen": "futbolito"
  },
  {
    "id": 3,
    "nombre": "Cancha Vóley",
    "tipoSuperficie": "Piso de madera, con acabado de alto agarre.",
    "dimensiones": "18 metros el largo por 9 metros de ancho.",
    "medidas": "La altura de la red es Ajustable a 2.45 metros o 2.25 metros",
    "jugadores": "Son 12 jugadores en cancha 6 por cada lado",
    "descripcion": "Una cancha a nivel competitivo ideal para los atletas de alto rendimiento.",
    "ubicacion": "Francisco de Villagra 6581, La reina",
    "precioHora": 15000.0,
    "imagen": "voley"
  },
  {
    "id": 4,
    "nombre": "Cancha Tenis",
    "tipoSuperficie": "Pista Dura.",
    "dimensiones": "23.80 metros de largo por 11 metros de ancho para 2 vs 2 y 8.25 metros de ancho para 1 vs 1.",
    "medidas": "La altura de la red es de 1.1 metros en los postes y 0.9 metros en el centro.",
    "jugadores": "Lo maximo son 4 jugadores lo normal son 2 o 1 por cada lado",
    "descripcion": "Cancha de nivel competitivo ideal para el alto rendimiento.",
    "ubicacion": "Francisco de Villagra 6581, La reina",
    "precioHora": 18000.0,
    "imagen": "tenis"
  },
  {
    "id": 5,
    "nombre": "Cancha Basquetball",
    "tipoSuperficie": "Piso de madera maple profesional, ideal para competiciones de alto rendimiento.",
    "dimensiones": "Largo total 28 metros, ancho total 14 metros para media cancha).",
    "medidas": "Altura del aro 3.05 metros.",
    "jugadores": " Máximo 10 jugadores 5 por lado.",
    "descripcion": "Cancha de madera, ideal para entrenamientos de alto rendimiento.",
    "ubicacion": "Francisco de Villagra 6581, La reina",
    "precioHora": 21500.0,
    "imagen": "basquet"
  }
]
"""

    // Carga los datos localmente.
    suspend fun cargarCanchas(): List<Cancha> {
        delay(500) // Simula la latencia de red/carga.
        return try {
            val listType = object : TypeToken<List<Cancha>>() {}.type
            gson.fromJson<List<Cancha>>(canchasJson, listType)
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }

    // Obtiene los datos localmente.
    suspend fun obtenerCanchaPorId(id: Int): Cancha {
        delay(100) // Simula la latencia de red/carga.
        val listType = object : TypeToken<List<Cancha>>() {}.type
        val canchas = gson.fromJson<List<Cancha>>(canchasJson, listType)
        return canchas.firstOrNull { it.id == id } ?: throw NoSuchElementException("Cancha with ID $id not found")
    }
}