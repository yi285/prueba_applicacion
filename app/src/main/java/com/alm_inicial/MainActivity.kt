package com.alm_inicial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size // Importante para el tamaño de la imagen
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Llama a la función principal de la interfaz
            PantallaContador()
        }
    }
}

@Composable
fun PantallaContador() {
    // --- ESTADOS (Variables que guardan datos y actualizan la pantalla) ---
    var usuario by remember { mutableStateOf("") } // Guarda lo que el usuario escribe
    var contrasena by remember { mutableStateOf("") } // Guarda la contraseña
    var mensajeResultado by remember { mutableStateOf("") } // Guarda el mensaje de error o éxito

    // Datos correctos para comparar
    val usua = "angel"
    val contra = "1234"


    // --- DISEÑO (Layout) ---
    // Column organiza los elementos verticalmente
    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupa toda la pantalla
            .padding(16.dp), // Margen exterior
        // Centra todos los elementos verticalmente en la pantalla
        verticalArrangement = Arrangement.Center,
        // Centra los elementos horizontalmente
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // --- LOGO ---
        Image(
            painter = painterResource(id = R.drawable.logo), // Busca la imagen 'logo' en res/drawable
            contentDescription = "icon",
            modifier = Modifier.size(240.dp) // Define el tamaño de la imagen
        )

        // --- ESPACIADOR (Separa imagen de texto) ---
        Spacer(modifier = Modifier.height(2.dp)) // Separación física entre elementos

        // --- TÍTULO ---
        Text(
            text = "inicio sesion",
            fontSize = 20.sp, // Tamaño de letra
            modifier = Modifier.padding(bottom = 16.dp) // Espacio solo abajo para el centrado
        )

        // --- CAMPO DE USUARIO ---
        OutlinedTextField(
            value = usuario, // Muestra lo que hay en la variable usuario
            onValueChange = { nuevoTexto -> usuario = nuevoTexto }, // Cuando escribes, actualiza la variable
            label = { Text("Introduce tu usuario", fontSize = 14.sp) }, // Etiqueta del campo
            modifier = Modifier.padding(bottom = 8.dp) // Espacio debajo del campo
        )

        // --- CAMPO DE CONTRASEÑA ---
        OutlinedTextField(
            value = contrasena,
            onValueChange = { nuevoTexto -> contrasena = nuevoTexto },
            label = { Text("Introduce tu contraseña", fontSize = 14.sp) },
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // --- BOTÓN Y LÓGICA ---
        Button(
            onClick = {
                // Lógica de comprobación al hacer clic
                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    mensajeResultado = "Por favor, introduzca los valores"
                } else if (usuario == usua && contrasena == contra) {
                    mensajeResultado = "¡Logro iniciar sesión!"
                } else {
                    mensajeResultado = "Usuario o contraseña incorrectos"
                }
            },
            modifier = Modifier.padding(bottom = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF1D3B4F), // Color de fondo del botón
                contentColor = Color.White // Color del texto del botón
            ),
        ) {
            Text("Iniciar Sesión", fontSize = 14.sp)
        }

        // --- MENSAJE DE RESULTADO ---
        Text(
            text = mensajeResultado,
            fontSize = 12.sp,
            // Si el mensaje empieza con ¡ es verde, si no, es rojo
            color = if (mensajeResultado.startsWith("¡")) Color.Green else Color.Red,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}