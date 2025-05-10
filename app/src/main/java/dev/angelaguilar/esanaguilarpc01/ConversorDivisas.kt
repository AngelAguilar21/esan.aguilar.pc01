package dev.angelaguilar.esanaguilarpc01

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.navigation.*

@Composable
fun conversorDivisas(navController: NavHostController){
    var monto by remember { mutableStateOf("") }
    var tipoConversion by remember { mutableStateOf("USD a PEN") }
    var resultado by remember { mutableStateOf<String?>(null) }

    // Tasa de conversión
    val tasaConversion = 3.80

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("Conversor de Moneda", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = monto,
            onValueChange = { monto = it },
            label = { Text("Monto a convertir") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = tipoConversion == "USD a PEN",
                onClick = { tipoConversion = "USD a PEN" }
            )
            Text("USD a PEN", modifier = Modifier.padding(start = 8.dp))

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = tipoConversion == "PEN a USD",
                onClick = { tipoConversion = "PEN a USD" }
            )
            Text("PEN a USD", modifier = Modifier.padding(start = 8.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (monto.isNotEmpty()) {
                    val montoNumerico = monto.toDoubleOrNull()
                    if (montoNumerico != null) {
                        val conversion = if (tipoConversion == "USD a PEN") {
                            montoNumerico * tasaConversion
                        } else {
                            montoNumerico / tasaConversion
                        }

                        resultado = if (tipoConversion == "USD a PEN") {
                            "S/ ${"%.2f".format(conversion)}"
                        } else {
                            "$${"%.2f".format(conversion)}"
                        }
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Convertir")
        }

        Spacer(modifier = Modifier.height(16.dp))

        resultado?.let {
            Text(
                text = "Resultado: $it",
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


