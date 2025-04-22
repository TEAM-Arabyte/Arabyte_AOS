package com.konkuk.arabyte_aos.presentation.ui.signup.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.signup.SignUpRoute

fun NavController.navigationSignUp() {
    navigateBottomMain(SignUpRoute.ROUTE)
}

fun NavGraphBuilder.signUpNavGraph(
    paddingValues: PaddingValues,
    navigateToOnboarding: () -> Unit,
) {
    composable(route = SignUpRoute.ROUTE) {
        SignUpRoute(
            innerPaddingValues = paddingValues,
            navigateToOnboarding = navigateToOnboarding,
        )
    }
}

object SignUpRoute {
    const val ROUTE = "SignUp"
}
