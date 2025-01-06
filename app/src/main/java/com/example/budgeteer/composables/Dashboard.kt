package com.example.budgeteer.composables

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
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
import kotlinx.coroutines.launch

class Dashboard : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            BudgeteerTheme {
                Surface (
//                    modifier = Modifier.fillMaxSize()
                ) {
                    ShowNavigationBar()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ShowNavigationBar() {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(SteelBlue)
                        .fillMaxWidth()
                        .height(150.dp)
                ) {

                }
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text(text = "All Budget List", color = SteelBlue)
                    },
                    selected = false,
                    icon = {
                        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = "budget list", tint = SteelBlue)
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.AllBudgetList.screen) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Profile", color = SteelBlue)
                    },
                    selected = false,
                    icon = {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "profile", tint = SteelBlue)
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Settings", color = SteelBlue)
                    },
                    selected = false,
                    icon = {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = "settings", tint = SteelBlue)
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Logout", color = SteelBlue)
                    },
                    selected = false,
                    icon = {
                        Icon(imageVector = Icons.Default.Close, contentDescription = "logout", tint = SteelBlue)
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar (
                    title = { Text(text = "Budgeteer")},
                    navigationIcon = {
                        IconButton (
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                Icons.Rounded.Menu, contentDescription = "menu button",
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = SteelBlue,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    ),
                    actions = {
                        IconButton (
                            onClick = {Toast.makeText(context, "Clicked notifications icon", Toast.LENGTH_SHORT).show()}
                        ) {
                            Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications Icon", tint = Color.White)
                        }
                        IconButton (
                            onClick = {Toast.makeText(context, "Clicked search icon", Toast.LENGTH_SHORT).show()}
                        ) {
                            Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon", tint = Color.White)
                        }
                        IconButton (
                            onClick = {Toast.makeText(context, "Clicked options icon", Toast.LENGTH_SHORT).show()}
                        ) {
                            Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Options Icon", tint = Color.White)
                        }
                    }
                )
            }
        ) {
            NavHost(
                navController = navigationController,
                startDestination = Screens.AllBudgetList.screen
            ) {
                composable(Screens.AllBudgetList.screen) {
                    AllBudgetList()
                }
                composable(Screens.Profile.screen) {
                    Profile()
                }
                composable(Screens.Settings.screen) {
                    Settings()
                }
            }
        }
    }
}