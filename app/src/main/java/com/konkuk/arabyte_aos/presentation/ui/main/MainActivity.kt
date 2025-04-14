package com.konkuk.arabyte_aos.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.MainNavigator
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.rememberMainNavigator
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigator: MainNavigator = rememberMainNavigator()
            ArabyteAOSTheme {
                MainScreen(navigator = navigator)
            }
        }
    }
}
