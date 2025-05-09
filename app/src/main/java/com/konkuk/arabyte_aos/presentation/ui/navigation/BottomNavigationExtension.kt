package com.konkuk.arabyte_aos.presentation.ui.navigation

import androidx.navigation.NavController
import com.konkuk.arabyte_aos.presentation.ui.home.navigation.HomeRoute

fun NavController.navigateBottomMain(route: String) {
    navigate(route) {
        popUpTo(HomeRoute.ROUTE) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}