package com.example.secureyourcourt.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Contacto") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        listOf(
                            Color(0xFF0D47A1),
                            Color(0xFF2196F3)
                        )
                    )
                ),
            contentAlignment = Alignment.TopCenter
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(top = 32.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

                Text(
                    "Ponte en contacto con nosotros.",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

                Text(
                    text = "Si necesitas ayuda con una reserva o algun reclamo puedes contactarnos a través de los siguientes medios:",
                    fontSize = 18.sp,
                    color = Color.White,
                    lineHeight = 26.sp
                )

                // CORREO
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Email, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("soporte@secureyourcourt.cl", fontSize = 18.sp, color = Color.White)
                }

                // TELÉFONO
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Phone, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("+56 9 2143 6587", fontSize = 18.sp, color = Color.White)
                }

                // HORARIO
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Schedule, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("Atención: 9:50 AM - 22:50 PM", fontSize = 18.sp, color = Color.White)
                }

                // REDES SOCIALES
                Text(
                    "Síguenos en nuestras redes sociales:",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White
                )

                // FACEBOOK
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Facebook, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("@SecureYourCourt.cl", fontSize = 18.sp, color = Color.White)
                }

                // INSTAGRAM
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.CameraAlt, contentDescription = null, tint = Color.White)
                    Spacer(modifier = Modifier.width(10.dp))
                    Text("@SecureYourCourt.cl", fontSize = 18.sp, color = Color.White)
                }

            }
        }
    }
}
