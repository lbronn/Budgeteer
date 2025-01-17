package com.example.budgeteer.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class DashboardViewModel: ViewModel() {
    var showBottomSheet by mutableStateOf(false)
}