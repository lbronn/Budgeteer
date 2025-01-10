package com.example.budgeteer.composableScreensHandler

sealed class Screens(val screen: String) {
    data object AllBudgetList: Screens("allBudgetList")
    data object Profile: Screens("profile")
    data object Settings: Screens("settings")
    data object BajeetBot: Screens("bajeetbot")
    data object AddBudget: Screens("addBudget")
    data object Notifications: Screens("notifications")
}