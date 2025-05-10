package dev.angelaguilar.esanaguilarpc01


import androidx.compose.runtime.*
import androidx.navigation.compose.*
import androidx.navigation.*

@Composable
fun navegador(){
    var navController = rememberNavController();
    NavHost(navController = navController, startDestination = "principal"){
        composable("principal"){
            principal(navController)
        }
        composable("calculadoraCanina"){
            calculadoraCanina(navController)
        }
        composable("conversorDivisas"){
            conversorDivisas(navController)
        }
        composable("productosTecnologicos"){
            productosTecnologicos(navController)
        }
    }

}
