package com.konkuk.arabyte_aos.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.arabyteColors
import com.konkuk.arabyte_aos.ui.theme.arabyteTypography

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
            color = arabyteColors.mainBlue,
            style = arabyteTypography.capMed9,
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = arabyteColors.subBlue,
            style = arabyteTypography.bodyMed13,
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = arabyteColors.gray04,
            style = arabyteTypography.titleBold18,
        )
        Text(
            text = "Hello $name!",
            modifier = modifier,
            color = arabyteColors.gray08,
            style = arabyteTypography.titleExtra24,
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
