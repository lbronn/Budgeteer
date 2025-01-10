package com.example.budgeteer

// ---Unusable function/s AS OF NOW---
/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowTopBar() {
    val context = LocalContext.current.applicationContext
    TopAppBar (
        title = { Text(text = "Budgeteer")},
        navigationIcon = {
            IconButton (
                onClick = { Toast.makeText(context, "Clicked Budgeteer icon", Toast.LENGTH_SHORT).show()}
            ) {
                Icon(painter = painterResource(id = R.drawable.splash_icon_transparent), contentDescription = "Budgeteer Icon")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = SteelBlue,
            titleContentColor = Color.White,
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

@Composable
fun ShowBox() {
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box (
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .width(350.dp)
                .height(150.dp)
                .background(Color.Blue)
        ) {
            Text (
                text = "Welcome mga kupal!",
                textAlign = TextAlign.Center,
                color = Color.White,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@Composable
fun ShowColumn() {
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
        modifier = Modifier.padding(20.dp)
    ) {
        Text (
            text = "Welcome to Budgeteer!",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

    }
}

@Composable
fun ShowRow() {
    Row (
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(20.dp)
    ) {
        var age by remember {
            mutableIntStateOf(0)
        }
        Button (
            onClick = { age++ },
            shape = RoundedCornerShape(size = 15.dp),
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            modifier = Modifier.padding(20.dp)
        ) {
            Text (
                text = when(age) {
                    0 -> "Click here to increase my age!"
                    else -> "Click here to increase my age! Age: $age"
                },
                textAlign = TextAlign.Center,
                color = Color.Black,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = Modifier.padding(5.dp)
            )
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun ShowSideNavigationBar() {
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
                        Text(
                            text = "All Budget List",
                            color = SteelBlue
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.ShoppingCart,
                            contentDescription = "budget list",
                            tint = SteelBlue
                        )
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
                        Text(
                            text = "Profile",
                            color = SteelBlue
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
                        navigationController.navigate(Screens.Profile.screen) {
                            popUpTo(0)
                        }
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(
                            text = "Logout",
                            color = SteelBlue
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "settings",
                            tint = SteelBlue
                        )
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
                        Text(
                            text = "Logout",
                            color = SteelBlue
                        )
                    },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Close,
                            contentDescription = "logout",
                            tint = SteelBlue
                        )
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
                            onClick = {
                                Toast.makeText(context, "Clicked notifications icon", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = "Notifications Icon",
                                tint = Color.White
                            )
                        }
                        IconButton (
                            onClick = {
                                Toast.makeText(context, "Clicked notifications icon", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = "Notifications Icon",
                                tint = Color.White
                            )
                        }
                        IconButton (
                            onClick = {
                                Toast.makeText(context, "Clicked notifications icon", Toast.LENGTH_SHORT).show()
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Notifications,
                                contentDescription = "Notifications Icon",
                                tint = Color.White
                            )
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
                    .fillMaxHeight(0.23f)
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
*/