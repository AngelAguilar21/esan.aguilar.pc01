package dev.angelaguilar.esanaguilarpc01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calculadoraCanina(navController: NavHostController) {
    var edadPerro by remember { mutableStateOf("") }
    var seleccionado by remember { mutableStateOf("Pequeño") }
    var edadPerroEnAnos by remember { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(40.dp)) {
        Text("Calculadora de Edad Canina", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = edadPerro,
            onValueChange = { edadPerro = it },
            label = { Text("Edad del perro en años humanos") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = true }
        ) {
            TextField(
                value = seleccionado,
                onValueChange = {},
                label = { Text("Tamaño del perro") },
                readOnly = true,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown icon"
                    )
                },
                modifier = Modifier.fillMaxWidth()
            )

            ExposedDropdownMenu (
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
            DropdownMenuItem(
                text = { Text("Pequeño") }, // Fixed
                onClick = {
                    seleccionado = "Pequeño"
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Mediano") }, // Fixed
                onClick = {
                    seleccionado = "Mediano"
                    expanded = false
                }
            )
            DropdownMenuItem(
                text = { Text("Grande") }, // Fixed
                onClick = {
                    seleccionado = "Grande"
                    expanded = false
                }
            )
        }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (edadPerro.isNotEmpty()) {
                    val edadHumana = edadPerro.toIntOrNull()
                    if (edadHumana != null) {
                        val edadCanina = when (seleccionado) {
                            "Pequeño" -> edadHumana * 5
                            "Mediano" -> edadHumana * 6
                            "Grande" -> edadHumana * 7
                            else -> 0
                        }
                        edadPerroEnAnos = "$edadHumana años humanos equivalen a $edadCanina años perro. ¡Es todo un cachorro en su corazón!"
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular Edad Perro")
        }

        Spacer(modifier = Modifier.height(16.dp))

        edadPerroEnAnos?.let {
            Text(
                text = it,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("principal") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
