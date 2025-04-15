package com.konkuk.arabyte_aos.presentation.ui.login.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.login.LoginRoute

fun NavController.navigationLogin() {
    navigate(
        route = LoginRoute.ROUTE,
    ) {
        popUpTo(graph.startDestinationId) { inclusive = true }
        launchSingleTop = true
    }
}

fun NavGraphBuilder.loginNavGraph(
    paddingValues: PaddingValues,
    navigateToHome: () -> Unit,
) {
    composable(route = LoginRoute.ROUTE) {
        LoginRoute(
            innerPaddingValues = paddingValues,
            navigateToHome = navigateToHome,
        )
    }
}

object LoginRoute {
    const val ROUTE = "Login"
}
