package com.example.mygaragee

sealed class Screen(val route: String) {
    object DisplayCarsScreen : Screen(route = "displaycarsscreen")
    object AddCarScreen : Screen(route = "addcarscreen")

    fun withNameArg(vararg args : String) : String {
        return buildString {
            append(route)
            args.forEach {arg ->
                append("/$arg")
            }
        }
    }
}
