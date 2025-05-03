package com.konkuk.arabyte_aos.presentation.ui.reviewwrite.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.reviewwrite.ReviewWriteRoute

fun NavController.navigationReviewWrite() {
    navigateBottomMain(ReviewWriteRoute.ROUTE)
}

fun NavGraphBuilder.reviewWriteNavGraph(
    paddingValues: PaddingValues,
) {
    composable(route = ReviewWriteRoute.ROUTE) {
        ReviewWriteRoute(
            innerPaddingValues = paddingValues,
        )
    }
}

object ReviewWriteRoute {
    const val ROUTE = "ReviewWrite"
}
