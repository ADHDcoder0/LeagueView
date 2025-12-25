package com.example.leagueview.view.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object DetailsScreen : Screen("details/{teamName}") {
        fun createRoute(teamName: String) = "details/$teamName"
    }
}