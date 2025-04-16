package com.konkuk.arabyte_aos.presentation.ui.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.type.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.ui.home.HomeRoute
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain

fun NavController.navigationHome() {
    navigateBottomMain(HomeRoute.ROUTE)
}

fun NavGraphBuilder.homeNavGraph(
    paddingValues: PaddingValues,
    navigateToReview: (ArabyteCategoryType?) -> Unit,
    navigateToNoticeBoard: () -> Unit,
    // MyProfileEditScreen, ReviewDetailScreen, BoardDetailScreen 등 추가
) {
    composable(route = HomeRoute.ROUTE) {
        HomeRoute(
            paddingValues = paddingValues,
            navigateToReview = navigateToReview,
            navigateToNoticeBoard = navigateToNoticeBoard,
        )
    }
}

object HomeRoute {
    const val ROUTE = "Home"
}
