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
}*/