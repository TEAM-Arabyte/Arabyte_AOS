package com.konkuk.arabyte_aos.presentation.ui.onboarding.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.onboarding.OnBoardingRoute

fun NavController.navigationOnboarding() {
    navigateBottomMain(OnboardingRoute.ROUTE)
}

fun NavGraphBuilder.onboardingNavGraph(
    paddingValues: PaddingValues,
    navigateToHome: () -> Unit,
) {
    composable(route = OnboardingRoute.ROUTE) {
        OnBoardingRoute(
            innerPaddingValues = paddingValues,
            navigateToHome = navigateToHome,
        )
    }
}

object OnboardingRoute {
    const val ROUTE = "Onboarding"
}
