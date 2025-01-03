package com.example.budgeteer.composables

import android.os.Bundle
import android.provider.MediaStore.Video
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.budgeteer.R
import com.example.budgeteer.ui.theme.BudgeteerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {
            BudgeteerTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                ) {
                    ShowText()
                }
            }
        }
    }
}

@Composable
fun ShowText() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .width(350.dp)
                .height(350.dp)
                .background(Color.Blue)
        ) {
            Text(
                text = "Hello mga kupal welcome to Budgeteer",
                textAlign = TextAlign.Center,
                color = Color.White,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                modifier = Modifier.padding(12.dp).align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowPreview() {
    BudgeteerTheme {
        ShowText()
    }
}