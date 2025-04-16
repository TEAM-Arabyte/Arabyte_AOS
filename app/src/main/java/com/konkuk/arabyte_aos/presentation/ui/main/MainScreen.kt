package com.konkuk.arabyte_aos.presentation.ui.main

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import com.konkuk.arabyte_aos.presentation.type.MainNavigationBarItemType
import com.konkuk.arabyte_aos.presentation.ui.component.navigator.MainBottomBar
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.MainNavHost
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.MainNavigator
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.rememberMainNavigator

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
) {
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
        content = { padding ->
            MainNavHost(
                navigator = navigator,
                paddingValues = padding,
            )
        },
        bottomBar = {
            MainBottomBar(
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
