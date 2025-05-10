package dev.angelaguilar.esanaguilarpc01

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextOverflow
import coil.compose.rememberImagePainter
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.navigation.*
import coil.compose.rememberAsyncImagePainter
import java.text.NumberFormat
import java.util.*

data class Producto(
    val nombre: String,
    val precio: Double,
    val categoria: String,
    val imagenUrl: String
)

@Composable
fun productosTecnologicos(navController: NavHostController){
    val productos = listOf(
        Producto(
            nombre = "Laptop Dell XPS 13",
            precio = 1200.0,
            categoria = "Laptop",
            imagenUrl = "https://m.media-amazon.com/images/I/81aI36Tc0XS._AC_SL1500_.jpg"
        ),
        Producto(
            nombre = "Smartphone Samsung Galaxy S21",
            precio = 799.99,
            categoria = "Smartphone",
            imagenUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmeT4QV0RSPSAyfSyA-IjB8Rzna3u63J4lDg&s"
        ),
        Producto(
            nombre = "Auriculares Bluetooth",
            precio = 150.0,
            categoria = "Accesorio",
            imagenUrl = "https://rimage.ripley.com.pe/home.ripley/Attachment/MKP/3092/PMP20000523301/full_image-1.jpeg"
        ),
        Producto(
            nombre = "Monitor LG 27 pulgadas",
            precio = 300.0,
            categoria = "Accesorio",
            imagenUrl = "https://www.lg.com/content/dam/channel/wcms/pa/images/monitors/27mp60g-b_awp_esps_pa_c/gallery/1600_01.jpg"
        )
    )

    val total = productos.sumOf { it.precio }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Listado de Productos", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(productos) { producto ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Row(modifier = Modifier.padding(16.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(producto.imagenUrl),
                            contentDescription = producto.nombre,
                            modifier = Modifier
                                .size(100.dp)
                                .padding(end = 16.dp)
                        )
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .align(Alignment.CenterVertically)
                        ) {
                            Text(
                                text = producto.nombre,
                                style = MaterialTheme.typography.titleMedium,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Categoría: ${producto.categoria}",
                                style = MaterialTheme.typography.bodyMedium
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(
                                text = "Precio: $${"%.2f".format(producto.precio)}",
                                style = MaterialTheme.typography.bodyLarge,
                            )
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Total acumulado: $${"%.2f".format(total)}",
            style = MaterialTheme.typography.titleLarge,
            color = Color(0xFF0288D1),
            modifier = Modifier.padding(top = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { navController.navigate("principal") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}

