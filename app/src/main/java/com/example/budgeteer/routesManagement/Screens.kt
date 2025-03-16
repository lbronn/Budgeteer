package com.example.budgeteer.routesManagement

sealed class Screens(val route: String) {
    data object Login: Screens("login")
    data object Register: Screens("register")
    data object Dashboard: Screens("dashboard")
    data object AllBudgetList: Screens("allBudgetList")
    data object Profile: Screens("profile")
    data object Settings: Screens("settings")
    data object BajeetBot: Screens("bajeetbot")
    data object AddBudget: Screens("addBudget")
    data object Notifications: Screens("notifications")
}