package com.example.mygaragee

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val repository = remember { Repository() }
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.DisplayCarsScreen.route) {
        composable(Screen.DisplayCarsScreen.route) {
            DisplayCarsScreen(navController, repository)
        }
        composable(Screen.AddCarScreen.route) {
            AddCarScreen(repository) {
                navController.popBackStack()
            }
        }
        composable(Screen.UpdateCarScreen.route) {

        }
        composable("deleteCar/{carId}") { backStackEntry ->
            val carId = backStackEntry.arguments?.getString("carId")?.toIntOrNull()
            DeleteCarScreen(
                repository = repository,
                carId = carId,
                onDeleteCanceled = {
                    navController.popBackStack()
                },
                onDeleteConfirmed = {
                    navController.popBackStack()
                }
            )
        }
    }
}