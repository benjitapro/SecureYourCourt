package com.example.secureyourcourt.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ContactMail
import androidx.compose.material.icons.filled.SportsSoccer
import com.example.secureyourcourt.R

@Composable
fun InicioScreen(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF0D47A1),
                        Color(0xFF2196F3)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(0.85f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(25.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.fff),
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)
            )

            Text(
                text = "Secure Your Court",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Reserva tu cancha rápida, fácil y segura",
                fontSize = 18.sp,
                color = Color.White.copy(alpha = 0.9f)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // BOTÓN PARA VER CANCHAS
            Button(
                onClick = { navController.navigate("catalogo") },
                modifier = Modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Icon(Icons.Filled.SportsSoccer, contentDescription = "Canchas", tint = Color(0xFF0D47A1))
                Spacer(Modifier.width(8.dp))
                Text("Ver Canchas", color = Color(0xFF0D47A1), fontSize = 18.sp)
            }

            // BOTÓN ACERCA DE NOSOTROS
            Button(
                onClick = { navController.navigate("about") },
                modifier = Modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Icon(Icons.Filled.Info, contentDescription = "Info", tint = Color(0xFF0D47A1))
                Spacer(Modifier.width(8.dp))
                Text("Acerca de Nosotros", color = Color(0xFF0D47A1), fontSize = 18.sp)
            }

            // BOTÓN DE CONTACTO
            Button(
                onClick = { navController.navigate("contact") },
                modifier = Modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(Color.White)
            ) {
                Icon(Icons.Filled.ContactMail, contentDescription = "Contacto", tint = Color(0xFF0D47A1))
                Spacer(Modifier.width(8.dp))
                Text("Contacto", color = Color(0xFF0D47A1), fontSize = 18.sp)
            }
        }
    }
}