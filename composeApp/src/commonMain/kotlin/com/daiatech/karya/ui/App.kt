package com.daiatech.karya.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.daiatech.karya.ui.screens.ComponentScreen
import com.daiatech.karya.ui.screens.HomeScreen
import com.daiatech.karya.ui.screens.SettingsScreen

@Composable
fun App(
    onNavHostReady: suspend (NavController) -> Unit = {}
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = Modifier.fillMaxSize()
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToComponent = { component ->
                    navController.navigate(component.route)
                }
            )
        }

        composable("settings") {
            SettingsScreen { navController.navigateUp() }
        }

        Components.entries.forEach { component ->
            composable(component.route) {
                ComponentScreen(
                    component = component,
                    navigateToSettings = { navController.navigate("settings") },
                    navigateUp = { navController.navigateUp() },
                )
            }
        }
    }

    LaunchedEffect(navController) {
        onNavHostReady(navController)
    }
}
