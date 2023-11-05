package com.example.mygaragee

sealed class Screen(val route: String) {
    object DisplayCarsScreen : Screen(route = "displaycarsscreen")
    object AddCarScreen : Screen(route = "addcarscreen")
    object UpdateCarScreen : Screen(route = "updatecarscreen/{carId}") {
        fun createRoute(carId: Int) = "updatecarscreen/$carId"
    }
    //object DeleteCarScreen : Screen(route = "deletecarscreen/{carId}") {
    //    fun createRoute(carId: Int) = "deletecarscreen/$carId"
    //}

}
