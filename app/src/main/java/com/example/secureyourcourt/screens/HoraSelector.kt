package com.example.secureyourcourt.screens

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxWidth

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HoraSelector(
    hora: String,
    onHoraSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val horasDisponibles = listOf(
        "10:00", "11:05", "12:10", "13:15",
        "14:20", "15:25", "16:30", "17:35",
        "18:40", "19:45", "20:50", "21:55"
    )

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {

        OutlinedTextField(
            value = hora,
            onValueChange = {},
            readOnly = true,
            label = { Text("Hora") },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            horasDisponibles.forEach { h ->
                DropdownMenuItem(
                    text = { Text(h) },
                    onClick = {
                        onHoraSelected(h)
                        expanded = false
                    }
                )
            }
        }
    }
}