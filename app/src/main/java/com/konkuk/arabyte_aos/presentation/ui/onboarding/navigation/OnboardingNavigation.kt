package com.konkuk.arabyte_aos.presentation.ui.onboarding.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.home.navigation.HomeRoute
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.onboarding.OnBoardingRoute
import com.konkuk.arabyte_aos.presentation.ui.signup.SignUpRoute
import com.konkuk.arabyte_aos.presentation.ui.signup.navigation.SignUpRoute

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
            navigateToHome = navigateToHome
        )
    }
}

object OnboardingRoute {
    const val ROUTE = "Onboarding"
}
