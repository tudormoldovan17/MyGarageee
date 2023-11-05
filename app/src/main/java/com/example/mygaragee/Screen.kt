package com.example.mygaragee

sealed class Screen(val route: String) {
    object DisplayCarsScreen : Screen(route = "displaycarsscreen")
    object AddCarScreen : Screen(route = "addcarscreen")

}
