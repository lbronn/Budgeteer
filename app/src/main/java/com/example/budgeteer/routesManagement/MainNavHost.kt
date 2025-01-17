package com.example.budgeteer.routesManagement

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.budgeteer.view.composable.Dashboard
import com.example.budgeteer.view.composable.Profile
import com.example.budgeteer.view.composable.Notifications
import com.example.budgeteer.view.composable.AllBudgetList
import com.example.budgeteer.view.composable.AddBudget
import com.example.budgeteer.view.composable.BajeetBot
import com.example.budgeteer.view.composable.Login
import com.example.budgeteer.view.composable.Settings

@Composable
fun MainNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Login.route) {
        composable(Screens.Login.route) {
            Login(
                loginSuccess = {
                    navController.navigate(Screens.Dashboard.route) {
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(Screens.Dashboard.route) {
            Dashboard(navController = navController)
        }

        composable(Screens.Profile.route) {
            Profile()
        }

        composable(Screens.Notifications.route) {
            Notifications()
        }

        composable(Screens.AllBudgetList.route) {
            AllBudgetList()
        }

        composable(Screens.AddBudget.route) {
            AddBudget()
        }

        composable(Screens.BajeetBot.route) {
            BajeetBot()
        }

        composable(Screens.Settings.route) {
            Settings()
        }
    }
}