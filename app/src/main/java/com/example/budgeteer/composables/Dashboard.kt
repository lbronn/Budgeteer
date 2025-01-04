package com.example.budgeteer.composables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.budgeteer.ui.theme.BudgeteerTheme

class Dashboard : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            BudgeteerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                ) {
//                    ShowTopBar()
                    ShowBox()
                    ShowColumn()
                    ShowRow()
                }
            }
        }
    }
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

/* ---Unusable function AS OF NOW---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowTopBar() {
    val context = LocalContext.current.applicationContext
    TopAppBar (
        title = { Text(text = "Budgeteer")},
        navigationIcon = {
            IconButton (
                onClick = {Toast.makeText(context, "Clicked Budgeteer icon", Toast.LENGTH_SHORT).show()}
            ) {
                Icon(painter = painterResource(id = R.drawable.splash_icon_transparent), contentDescription = "Budgeteer Icon")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.White,
            titleContentColor = Color.Black,
        ),
        actions = {
            IconButton (
                onClick = {Toast.makeText(context, "Clicked notifications icon", Toast.LENGTH_SHORT).show()}
            ) {
                Icon(imageVector = Icons.Filled.Notifications, contentDescription = "Notifications Icon", tint = Color.Blue)
            }
            IconButton (
                onClick = {Toast.makeText(context, "Clicked search icon", Toast.LENGTH_SHORT).show()}
            ) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Icon", tint = Color.Blue)
            }
            IconButton (
                onClick = {Toast.makeText(context, "Clicked options icon", Toast.LENGTH_SHORT).show()}
            ) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Options Icon", tint = Color.Blue)
            }
        }
    )
} */

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
    BudgeteerTheme {
//        ShowTopBar()
        ShowBox()
        ShowColumn()
        ShowRow()
    }
}