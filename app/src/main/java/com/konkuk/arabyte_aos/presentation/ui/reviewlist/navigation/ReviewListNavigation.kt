package com.konkuk.arabyte_aos.presentation.ui.reviewlist.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.reviewlist.ReviewListRoute

fun NavController.navigationReviewList(
    categoryType: ArabyteCategoryType?,
) {
    val category = categoryType?.name ?: ""
    val route = "${ReviewListRoute.ROUTE}/$category"
    navigateBottomMain(route)
}

fun NavGraphBuilder.reviewListNavGraph(
    paddingValues: PaddingValues,
    navigateToReviewDetailScreen: (reviewId: Int) -> Unit,
    navigateToReviewWrite: () -> Unit,
) {
    composable(
        route = ReviewListRoute.ROUTE_WITH_ARGUMENT,
        arguments =
            listOf(
                navArgument(ReviewListRoute.ARGUMENT) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
            ),
    ) { backStackEntry ->
        val categoryString = backStackEntry.arguments?.getString(ReviewListRoute.ARGUMENT)
        val categoryType =
            runCatching {
                ArabyteCategoryType.valueOf(categoryString ?: "")
            }.getOrNull()
        ReviewListRoute(
            innerPaddingValues = paddingValues,
            navigateToReviewDetail = { reviewId ->
                navigateToReviewDetailScreen(reviewId)
            },
            navigateToReviewWrite = navigateToReviewWrite,
        )
    }
}

object ReviewListRoute {
    const val ROUTE = "ReviewList"
    const val ARGUMENT = "CategoryType"
    const val ROUTE_WITH_ARGUMENT = "$ROUTE/{$ARGUMENT}"
}
