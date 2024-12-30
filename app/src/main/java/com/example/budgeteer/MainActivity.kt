package com.example.budgeteer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.budgeteer.ui.theme.BudgeteerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        val kupals = listOf(
            Kupals("Joed", "Secoya", 26),
            Kupals("Cchan", "Uy", 22),
            Kupals("Hermi", "Timtim", 21),
            Kupals("Lucky", "Uayan", 24),
            Kupals("Chow", "Taboada", 16),
            Kupals("Lance", "Salera", 12)
        )

        val kupalTitle: String = "Mga Kupals"
        val legalAgeKupals = kupals.filter { it.age >= 18 }

        setContent {
            BudgeteerTheme {
                LazyColumn {
                    item(kupalTitle) {
                        KupalTitle(title = kupalTitle)
                    }
                    items(legalAgeKupals) {
                        ShowKupals(it)
                    }
                }
            }
        }
    }
}

@Composable
fun KupalTitle(title: String) {
    Card(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            modifier = Modifier.padding(12.dp)
        )
    }
}

@Composable
fun ShowKupals(kupal: Kupals) {
    Card(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    ) {
        Row {
            Image(
                painter = painterResource(id = R.drawable.person_vector),
                contentDescription = "Sample image",
                modifier = Modifier.height(100.dp).width(100.dp)
            )
            Column {
                Text(
                    text = "First Name: " + kupal.firstName,
                    modifier = Modifier.padding(top = 14.dp)
                )
                Text(
                    text = "Last Name: " + kupal.lastName
                )
                Text(
                    text = "Age: " + kupal.age
                )
            }
        }
    }
}