package com.konkuk.arabyte_aos.presentation.ui.home.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.ui.home.HomeRoute
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain

fun NavController.navigationHome() {
    navigateBottomMain(HomeRoute.ROUTE)
}

fun NavGraphBuilder.homeNavGraph(
    paddingValues: PaddingValues,
    navigateToReviewList: (ArabyteCategoryType?) -> Unit,
    navigateToNoticeBoard: () -> Unit,
) {
    composable(route = HomeRoute.ROUTE) {
        HomeRoute(
            innerPaddingValues = paddingValues,
            onNavigateToNoticeBoardDetail = {},
            onNavigateToReviewList = {},
            onNavigateToReviewDetail = {},
            onNavigateToReviewCategory = {},
            onNavigateToMyPage = {},
            onNavigateToNoticeBoard = {},
        )
    }
}

object HomeRoute {
    const val ROUTE = "Home"
}
