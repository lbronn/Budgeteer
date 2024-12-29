package com.example.budgeteer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.budgeteer.ui.theme.BudgeteerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        val kupals = listOf("Joed", "Kenj", "Cchan", "Lance", "Jumong", "Menec", "Joed", "Kenj", "Cchan", "Lance", "Jumong", "Menec",
            "Joed", "Kenj", "Cchan", "Lance", "Jumong", "Menec")

        setContent {
            BudgeteerTheme {
                LazyColumn {
                    items(kupals) {
                        ShowKupals(it)
                    }
                }
            }
        }
    }
}

@Composable
fun ShowKupals(kupal: String) {
    Card(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.person_vector),
                contentDescription = "Sample image",
                modifier = Modifier.height(100.dp).width(100.dp)
            )
            Text(
                text = kupal,
                modifier = Modifier.padding(24.dp)
            )
        }
    }
}