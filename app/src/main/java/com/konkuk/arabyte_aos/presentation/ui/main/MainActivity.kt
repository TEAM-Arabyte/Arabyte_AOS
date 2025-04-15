package com.konkuk.arabyte_aos.presentation.ui.main

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.konkuk.arabyte_aos.presentation.ui.onboarding.OnBoardingRoute
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowInsetsControllerCompat
import androidx.hilt.navigation.compose.hiltViewModel
import com.konkuk.arabyte_aos.presentation.ui.signup.SignUpRoute
import com.konkuk.arabyte_aos.presentation.ui.splash.SplashScreen
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            installSplashScreen()
        }
        enableEdgeToEdge()

        setContent {
            val viewModel: MainViewModel = hiltViewModel()
            val showSplash by viewModel.showSplash.collectAsState()
            val window = this.window

            LaunchedEffect(showSplash) {
                val controller = WindowInsetsControllerCompat(window, window.decorView)
                controller.isAppearanceLightStatusBars = !showSplash
            }

            ArabyteAOSTheme {
                LaunchedEffect(Unit) {
                    viewModel.startSplashTimer()
                }
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { innerPadding ->
                    if (showSplash) {
                        SplashScreen(innerPaddingValues = innerPadding)
                    } else {
                        SignUpRoute(innerPaddingValues = innerPadding)
                    }
                }
            }
        }
    }
}
