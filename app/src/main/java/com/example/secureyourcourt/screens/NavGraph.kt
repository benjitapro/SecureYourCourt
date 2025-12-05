package com.example.secureyourcourt.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.secureyourcourt.navigation.BottomBar
import com.example.secureyourcourt.viewmodel.AuthViewModel
import com.example.secureyourcourt.viewmodel.CanchasViewModel
import com.example.secureyourcourt.viewmodel.CarritoViewModel

@Composable
fun NavGraph(
    authViewModel: AuthViewModel,
    canchasViewModel: CanchasViewModel,
    carritoViewModel: CarritoViewModel
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {

        //INICIO DE SESION
        composable("login") {
            LoginScreen(navController, authViewModel)
        }

        //REGISTRO
        composable("register") {
            RegisterScreen(navController, authViewModel)
        }

        //CON BARRA
        composable("inicio") {
            Scaffold(bottomBar = { BottomBar(navController, authViewModel) }) {
                InicioScreen(navController)
            }
        }

        //CON BARRA
        composable("catalogo") {
            Scaffold(bottomBar = { BottomBar(navController, authViewModel) }) {
                CatalogoScreen(navController, canchasViewModel)
            }
        }

        //CON BARRA
        composable("about") {
            Scaffold(bottomBar = { BottomBar(navController, authViewModel) }) {
                AboutScreen(navController)
            }
        }

        //CON BARRA
        composable("contact") {
            Scaffold(bottomBar = { BottomBar(navController, authViewModel) }) {
                ContactScreen(navController)
            }
        }

        //SIN BARRA
        composable("carrito") {
            CarritoScreen(navController, carritoViewModel)
        }

        //ADMIN
        composable("backoffice") {
            if (authViewModel.esAdmin()) BackOfficeScreen(navController)
            else Text("Acceso Denegado.")
        }

        //ADMIN
        composable("agregarProducto") {
            if (authViewModel.esAdmin()) AgregarProductoScreen(navController)
            else Text("Acceso Denegado.")
        }

        //SIN BARRA
        composable(
            "detalle/{id}",
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { entry ->
            val id = entry.arguments?.getInt("id")

            if (id != null) {
                DetalleCanchaScreen(
                    canchaId = id,
                    viewModel = canchasViewModel,
                    carritoViewModel = carritoViewModel,
                    navController = navController
                )
            } else {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("ID inválido.")
                }
            }
        }

        //SIN BARRA
        composable("reservaForm") {
            ReservaFormScreen(navController, carritoViewModel)
        }

        //SIN BARRA
        composable(
            "compraExitosa/{resumen}",
            arguments = listOf(navArgument("resumen") { type = NavType.StringType })
        ) { entry ->
            CompraExitosaScreen(navController, entry.arguments?.getString("resumen") ?: "")
        }

        //SIN BARRA
        composable(
            "compraRechazada/{msg}",
            arguments = listOf(navArgument("msg") { defaultValue = "Hubo un error." })
        ) { entry ->
            CompraRechazadaScreen(navController, entry.arguments?.getString("msg") ?: "")
        }
    }
}