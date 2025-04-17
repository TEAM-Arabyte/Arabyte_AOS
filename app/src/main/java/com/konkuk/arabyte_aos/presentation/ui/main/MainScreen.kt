package com.konkuk.arabyte_aos.presentation.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import com.konkuk.arabyte_aos.presentation.type.MainNavigationBarItemType
import com.konkuk.arabyte_aos.presentation.ui.component.navigator.MainBottomBar
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.MainNavHost
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.MainNavigator
import com.konkuk.arabyte_aos.presentation.ui.main.Navigator.rememberMainNavigator

@Composable
fun MainScreen(
    navigator: MainNavigator = rememberMainNavigator(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    MainScreenContent(
        navigator = navigator,
        innerPaddingValues = innerPaddingValues,
    )
}

@Composable
private fun MainScreenContent(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val navController = navigator.navHostController

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        modifier = modifier,
        content = { innerPadding ->
            MainNavHost(
                navigator = navigator,
                paddingValues =
                    PaddingValues(
                        top = innerPaddingValues.calculateTopPadding(),
                        bottom = innerPadding.calculateBottomPadding(),
                    ),
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
