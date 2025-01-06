package com.example.budgeteer.composable_screens_handler

sealed class Screens(val screen: String) {
    data object AllBudgetList: Screens("allBudgetList")
    data object Profile: Screens("profile")
    data object Settings: Screens("settings")
}