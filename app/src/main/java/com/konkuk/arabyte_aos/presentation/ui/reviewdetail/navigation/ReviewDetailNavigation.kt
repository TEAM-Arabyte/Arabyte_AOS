package com.konkuk.arabyte_aos.presentation.ui.reviewdetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.ReviewDetailRoute

fun NavController.navigationReviewDetail(reviewId: Int) {
    navigateBottomMain(ReviewDetailRoute.routeWithArgument(reviewId))
}

fun NavGraphBuilder.reviewDetailNavGraph(
    paddingValues: PaddingValues,
) {
    composable(
        route = ReviewDetailRoute.ROUTE_WITH_ARGUMENT,
        arguments =
            listOf(
                androidx.navigation.navArgument(ReviewDetailRoute.ARGUMENT) {
                    type = androidx.navigation.NavType.IntType
                },
            ),
    ) { backStackEntry ->
        val reviewId = backStackEntry.arguments?.getInt(ReviewDetailRoute.ARGUMENT) ?: -1
        ReviewDetailRoute(
            reviewId = reviewId,
            innerPaddingValues = paddingValues,
        )
    }
}

object ReviewDetailRoute {
    const val ROUTE = "ReviewDetail"
    const val ARGUMENT = "reviewId"
    const val ROUTE_WITH_ARGUMENT = "$ROUTE/{$ARGUMENT}"

    fun routeWithArgument(reviewId: Int): String = "$ROUTE/$reviewId"
}
