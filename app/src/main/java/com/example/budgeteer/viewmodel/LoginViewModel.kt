package com.example.budgeteer.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {
    var username by mutableStateOf("")
    var password by mutableStateOf("")
    var passwordEntered by mutableStateOf(false)

    fun userAuthentication(username: String, password: String): Boolean {
        val validUsername = "admin"
        val validPassword = "password"
        return username == validUsername && password == validPassword
    }
}