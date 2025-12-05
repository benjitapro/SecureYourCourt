package com.example.secureyourcourt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.secureyourcourt.screens.NavGraph
import com.example.secureyourcourt.viewmodel.AuthViewModel
import com.example.secureyourcourt.viewmodel.CanchasViewModel
import com.example.secureyourcourt.viewmodel.CarritoViewModel
import com.example.secureyourcourt.ui.theme.CanchasTheme

class MainActivity : ComponentActivity() {

    // viewModels principales
    private val authViewModel: AuthViewModel by viewModels()
    private val canchasViewModel: CanchasViewModel by viewModels()
    private val carritoViewModel: CarritoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CanchasTheme {
                NavGraph(
                    authViewModel = authViewModel,
                    canchasViewModel = canchasViewModel,
                    carritoViewModel = carritoViewModel
                )
            }
        }
    }
}
