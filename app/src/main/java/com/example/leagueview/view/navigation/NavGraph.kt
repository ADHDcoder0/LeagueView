package com.example.leagueview.view.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.leagueview.view.screens.DetailsScreen
import com.example.leagueview.view.screens.HomeScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {

        composable(Screen.HomeScreen.route) {
            HomeScreen(
                onClick = { teamName ->
                    navController.navigate(
                        Screen.DetailsScreen.createRoute(teamName)
                    )
                }
            )
        }

        composable(
            route = Screen.DetailsScreen.route,
            arguments = listOf(
                navArgument("teamName") { type = NavType.StringType }
            )
        ) { backStackEntry ->

            val teamName =
                backStackEntry.arguments?.getString("teamName") ?: ""

            DetailsScreen(
                teamName = teamName,
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
