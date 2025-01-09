package com.example.budgeteer.composable

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.budgeteer.composableScreensHandler.Screens
import com.example.budgeteer.ui.theme.BudgeteerTheme
import com.example.budgeteer.ui.theme.SteelBlue

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("RememberReturnType", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ShowBottomNavigationBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
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
                            showBottomSheet = true
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
            composable(Screens.AddBudget.screen) {
                AddBudget()
            }
        }
    }

    if(showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                BottomSheetItem(
                    image = Icons.Default.ShoppingCart,
                    text = "Add a Budget"
                ) {
                    showBottomSheet = false
                    navigationController.navigate(Screens.AddBudget.screen) {
                        popUpTo(0)
                    }
                }
                BottomSheetItem(
                    image = Icons.Default.Favorite,
                    text = "Add your favorite budgets"
                ) {
                    Toast.makeText(
                        context,
                        "Add your favorite budgets",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                BottomSheetItem(
                    image = Icons.Default.Create,
                    text = "Write your budget journals here"
                ) {
                    Toast.makeText(
                        context,
                        "Write your journal here",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}

@Composable
fun BottomSheetItem(image: ImageVector, text: String, onclick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.clickable {
            onclick()
        }
    ) {
        Icon(
            image,
            contentDescription = null,
            tint = SteelBlue
        )
        Text(
            text = text,
            color = SteelBlue
        )
    }
}