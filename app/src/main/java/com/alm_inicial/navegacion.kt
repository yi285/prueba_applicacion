package com.alm_inicial

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    //  declaramos el controlador de navegación
    val navController = rememberNavController()

    // startDestination indica cuál es la primera pantalla
    // el NavHost gestiona la navegación entre pantallas
    // el  navController es el que gestiona la navegación tambien
    // el  login es el nombre de la ruta
    NavHost(navController = navController, startDestination = "login") {

        // --- Ruta del Login ---
        composable("login") {
            // Aquí debes llamar a la función Composable
            // que tiene tu diseño de login actual = pantalla_principal
            //importante el nav controller
            pantalla_principal(navController)
        }

        // --- Ruta de la lista de libros ---
        //lista se refiere solo a un nombre de pantalla
        // puedes agregar mas rutas si quieres
        composable("lista") {
            pantalla2()
        }

        //el compensable sirve para agregar mas rutas
        //
    }
}


