package com.example.secureyourcourt.repository


import com.example.secureyourcourt.model.Reserva
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class ReservaRepository {

    private val db = FirebaseFirestore.getInstance()

    suspend fun guardarReserva(reserva: Reserva): Boolean {
        return try {
            db.collection("reservas")
                .add(reserva)
                .await()
            true
        } catch (e: Exception) {
            false
        }
    }
}