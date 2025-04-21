package com.konkuk.arabyte_aos.presentation.ui.navigation

import androidx.navigation.NavController

fun NavController.navigateBottomMain(route: String) {
    navigate(route) {
        popUpTo(graph.startDestinationId) { inclusive = true }
        launchSingleTop = true
    }
}
