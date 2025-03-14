package com.konkuk.arabyte_aos.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme.colors

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArabyteAOSTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Row {
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = ArabyteTheme.colors.mainBlue,
            style = ArabyteTheme.typography.capMed9,
        )
        Spacer(Modifier.height(9.dp).background(color = ArabyteTheme.colors.black))
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = ArabyteTheme.colors.subBlue,
            style = ArabyteTheme.typography.bodyMed13,
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = ArabyteTheme.colors.subBlue,
            fontSize = 13.sp,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArabyteAOSTheme {
        Greeting("Android")
    }
}
