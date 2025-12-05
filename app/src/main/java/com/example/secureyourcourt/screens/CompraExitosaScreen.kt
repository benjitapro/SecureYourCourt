package com.example.secureyourcourt.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.secureyourcourt.model.Reserva
import kotlinx.serialization.json.Json

@Composable
fun CompraExitosaScreen(navController: NavController, resumenJson: String) {

    // Convertimos JSON a Objeto Reserva
    val resumen = try {
        Json.decodeFromString<Reserva>(java.net.URLDecoder.decode(resumenJson, "UTF-8"))
    } catch (e: Exception) {
        null
    }

    Scaffold {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(20.dp)
            ) {

                Text("Reserva realizada con éxito!.", style = MaterialTheme.typography.headlineMedium)

                if (resumen != null) {
                    Card(
                        modifier = Modifier.fillMaxWidth(),
                        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp),
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ) {
                            Text("📌 Responsable: ${resumen.responsable}")
                            Text("👥 Jugadores: ${resumen.jugadores.joinToString()}")
                            Text("📅 Fecha: ${resumen.fecha}")
                            Text("⏰ Hora: ${resumen.hora}")
                            Text("🏟 Cancha: ${resumen.canchaNombre}")
                            Text("💵 Total: $${resumen.total}")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Button(onClick = { navController.navigate("catalogo") }) {
                    Text("Continuar Reservando")
                }

                Button(onClick = { navController.navigate("inicio") }) {
                    Text("Volver al Inicio")
                }
            }
        }
    }
}
