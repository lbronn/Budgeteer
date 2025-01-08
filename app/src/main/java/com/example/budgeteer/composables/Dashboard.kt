package com.example.budgeteer.composables

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgeteer.composable_screens_handler.Screens
import com.example.budgeteer.ui.theme.BudgeteerTheme
import com.example.budgeteer.ui.theme.SteelBlue

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            BudgeteerTheme {
                Surface (
//                    modifier = Modifier.fillMaxSize()
                ) {
                    ShowBottomNavigationBar()
                }
            }
        }
    }
}

@SuppressLint("RememberReturnType", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShowBottomNavigationBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = SteelBlue
            ) {
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screens.Profile.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "profile",
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Person) Color.White else Color.Gray
                    )
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.AccountBox
                        navigationController.navigate(Screens.BajeetBot.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.AccountBox,
                        contentDescription = "bajeet bot",
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.AccountBox) Color.White else Color.Gray
                    )
                }
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(
                        onClick = {
                            Toast.makeText(context, "Add button clicked", Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "add button",
                            tint = SteelBlue
                        )
                    }
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.ShoppingCart
                        navigationController.navigate(Screens.AllBudgetList.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.ShoppingCart,
                        contentDescription = "budget list",
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.ShoppingCart) Color.White else Color.Gray
                    )
                }
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Settings
                        navigationController.navigate(Screens.Settings.screen) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "settings",
                        modifier = Modifier.size(26.dp),
                        tint = if(selected.value == Icons.Default.Settings) Color.White else Color.Gray
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Profile.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Profile.screen) {
                Profile()
            }
            composable(Screens.BajeetBot.screen) {
                BajeetBot()
            }
            composable(Screens.AllBudgetList.screen) {
                AllBudgetList()
            }
            composable(Screens.Settings.screen) {
                Settings()
            }
        }
    }
}