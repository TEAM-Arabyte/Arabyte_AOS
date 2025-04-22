package com.konkuk.arabyte_aos.presentation.ui.reviewdetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.ReviewDetailRoute

fun NavController.navigationReviewDetail() {
    navigateBottomMain(ReviewDetailRoute.ROUTE)
}

fun NavGraphBuilder.reviewDetailNavGraph(
    paddingValues: PaddingValues,
) {
    composable(route = ReviewDetailRoute.ROUTE) {
        ReviewDetailRoute(
            innerPaddingValues = paddingValues,
        )
    }
}

object ReviewDetailRoute {
    const val ROUTE = "ReviewDetail"
}
