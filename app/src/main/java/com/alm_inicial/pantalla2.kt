package com.alm_inicial
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.graphics.Color
@Composable
fun pantalla2() {
    // Aseguramos que el Column ocupe toda la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        // permite que el contenido ocupe toda la pantalla
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Lista de Libros",
            fontSize = 24.sp,
            color = Color.Black
        )
        // cambiar la pagina para que sea funcional
    }
}