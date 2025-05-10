package dev.angelaguilar.esanaguilarpc01

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.unit.dp
import androidx.navigation.*

@Composable
fun principal(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { navController.navigate("calculadoraCanina") }
        ) {
            Text(text = "Calculadora canina")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("conversorDivisas") }
        ) {
            Text(text = "Conversor de divisas")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("productosTecnologicos") }
        ) {
            Text(text = "Productos tecnológicos")
        }
    }
}