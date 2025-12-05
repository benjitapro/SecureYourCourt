package com.example.secureyourcourt.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.secureyourcourt.viewmodel.AuthViewModel
import com.example.secureyourcourt.utils.isValidEmail
import com.example.secureyourcourt.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var mensajeError by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF42A5F5)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth(0.85f)
        ) {

            Image(
                painter = painterResource(id = R.drawable.fff),
                contentDescription = null,
                modifier = Modifier.size(120.dp)
            )

            Text(
                text = "Secure Your Court",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(bottom = 20.dp, top = 10.dp)
            )

            OutlinedTextField(
                value = email,
                onValueChange = {
                    email = it
                    mensajeError = null
                },
                label = { Text("Correo electrónico") },
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = Color(0xFF1565C0),
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color(0xFF1565C0),
                    unfocusedIndicatorColor = Color(0xFF1976D2),
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            OutlinedTextField(
                value = password,
                onValueChange = {
                    password = it
                    mensajeError = null
                },
                label = { Text("Contraseña") },
                colors = TextFieldDefaults.colors(
                    focusedLabelColor = Color(0xFF1565C0), // <-- Azul oscuro
                    cursorColor = Color.Black,
                    focusedIndicatorColor = Color(0xFF1565C0), // <-- Azul oscuro
                    unfocusedIndicatorColor = Color(0xFF1976D2), // <-- Azul medio
                    focusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black
                ),
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {

                    // ACCESO ADMIN SIN REGISTRO
                    if (email == "administrador@admin.com" && password == "admin123") {
                        viewModel.usuarioActual.value = "ADMIN"
                        navController.navigate("backoffice")
                        return@Button
                    }

                    // VALIDACIONES PARA NORMAL USER
                    when {
                        email.isBlank() || password.isBlank() -> {
                            mensajeError = "Debes ingresar tu correo y contraseña."
                        }
                        !email.isValidEmail() -> {
                            mensajeError = "Correo inválido."
                        }
                        else -> {
                            val success = viewModel.login(email.trim(), password)

                            if (success) {
                                mensajeError = null
                                navController.navigate("inicio") {
                                    popUpTo("login") { inclusive = true }
                                }
                            } else {
                                mensajeError = "Credenciales inválidas."
                            }
                        }
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(Color.White),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text("Iniciar Sesión", color = Color(0xFF1565C0), fontSize = 18.sp)
            }

            if (mensajeError != null) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = mensajeError ?: "",
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }

            Spacer(modifier = Modifier.height(15.dp))

            Text(
                text = "¿No tienes cuenta? Regístrate.",
                color = Color.White,
                fontSize = 16.sp,
                modifier = Modifier
                    .padding(top = 10.dp)
                    .clickable { navController.navigate("register") }
            )
        }
    }
}