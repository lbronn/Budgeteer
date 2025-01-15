package com.example.budgeteer.composable

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.budgeteer.routesManagement.Screens
import com.example.budgeteer.ui.theme.SteelBlue
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }

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
                ) {}
                HorizontalDivider()
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Profile"
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "profile",
                            tint = SteelBlue
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Profile.route)
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Notifications"
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "notifications",
                            tint = SteelBlue
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Notifications.route)
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "All Budgets List"
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "all budget list",
                            tint = SteelBlue
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.AllBudgetList.route)
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Logout"
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "logout",
                            tint = SteelBlue
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navController.navigate(Screens.Login.route) {
                            popUpTo(Screens.Login.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                val coroutineScope = rememberCoroutineScope()
                TopAppBar (
                    title = {
                        Text(text = "Budgeteer")
                    },
                    navigationIcon = {
                        IconButton (
                            onClick = {
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        ) {
                            Icon(
                                Icons.Rounded.Menu,
                                contentDescription = "menu button",
                                tint = Color.White
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = SteelBlue,
                        titleContentColor = Color.White,
                        navigationIconContentColor = Color.White
                    )
                )
            },
            bottomBar = {
                BottomAppBar(
                    containerColor = SteelBlue
                ) {
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Person
                            navController.navigate(Screens.Profile.route)
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
                            navController.navigate(Screens.BajeetBot.route)
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
                            navController.navigate(Screens.AllBudgetList.route)
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
                            navController.navigate(Screens.Settings.route)
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
        ) {

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
                        .fillMaxHeight(0.23f)
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    BottomSheetItem(
                        image = Icons.Default.ShoppingCart,
                        text = "Add a Budget"
                    ) {
                        showBottomSheet = false
                        navController.navigate(Screens.AddBudget.route)
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