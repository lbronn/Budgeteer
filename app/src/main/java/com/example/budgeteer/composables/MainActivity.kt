package com.example.budgeteer.composables

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.budgeteer.classes.Kupals
import com.example.budgeteer.classes.KupalsType
import com.example.budgeteer.R
import com.example.budgeteer.ui.theme.BudgeteerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        val kupals = listOf(
            Kupals("This is a text", "Joed Kupal", KupalsType.TEXT),
            Kupals("This is a text", "Cchan Kupal", KupalsType.TEXT),
            Kupals("This is an image", "Lance Kupal", KupalsType.IMAGE),
            Kupals("This is a video", "Rico Kupal", KupalsType.VIDEO),
            Kupals("This is an image", "Menec Kupal", KupalsType.IMAGE),
            Kupals("This is a video", "Kenj Kupal", KupalsType.VIDEO),
        )

        val kupalTitle = "Mga Kupals"

        setContent {
            BudgeteerTheme {
                LazyColumn {
                    item(kupalTitle) {
                        KupalTitle(title = kupalTitle)
                    }
                    items(kupals) {
                        when (it.type) {
                            KupalsType.TEXT -> {
                                ShowKupalsText(it)
                            }
                            KupalsType.IMAGE -> {
                                ShowKupalsImage(it)
                            }
                            KupalsType.VIDEO -> {
                                ShowKupalsVideo(it)
                            }
                        }
                    }
                }
            }
        }
    }
}

//@Preview
@Composable
fun KupalTitle(title: String) {
    Card(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    ) {
        Text(
            text = title,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            modifier = Modifier.padding(12.dp)
        )
    }
}

//@Preview
@Composable
fun ShowKupalsText(kupal: Kupals) {
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
                    text = kupal.header,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 14.dp)
                )
                Text(
                    text = "Title: " + kupal.text,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}

@Composable
fun ShowKupalsImage(kupal: Kupals) {
    Card(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    ) {
        Text(
            text = kupal.header,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 12.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.person_vector),
            contentDescription = "Sample image",
            modifier = Modifier.height(350.dp).width(350.dp)
        )
    }
}

@Composable
fun ShowKupalsVideo(kupal: Kupals) {
    Card(
        modifier = Modifier.fillMaxSize().padding(12.dp)
    ) {
        Text(
            text = kupal.header,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 12.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.person_vector),
            contentDescription = "Sample video",
            modifier = Modifier.height(350.dp).width(350.dp)
        )
    }
}