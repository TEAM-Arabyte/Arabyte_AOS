package com.konkuk.arabyte_aos.presentation.ui.main

import android.app.Activity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import com.konkuk.arabyte_aos.presentation.type.MainNavigationBarItemType
import com.konkuk.arabyte_aos.presentation.ui.component.navigator.MainBottomBar
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.MainNavHost
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.MainNavigator
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.rememberMainNavigator

@Composable
fun TransparentStatusBarEffect() {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = true
        }
    }
}

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
    TransparentStatusBarEffect()
    MainScreenContent(
        navigator = navigator,
    )
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
) {
    val navController = navigator.navHostController

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        content = { innerPadding ->
            MainNavHost(
                navigator = navigator,
                paddingValues = PaddingValues(bottom = innerPadding.calculateBottomPadding()),
            )
        },
        bottomBar = {
            MainBottomBar(
                modifier = Modifier.navigationBarsPadding(),
                isVisible = navigator.showBottomBar(),
                navigationBarItems = MainNavigationBarItemType.entries.toList(),
                currentNavigationBarItem = navigator.currentMainNavigationBarItem,
                onNavigationBarItemSelected = { item ->
                    if (currentRoute != item.route.toString()) {
                        navigator.navigateMainNavigation(item)
                    }
                },
            )
        },
    )
}
