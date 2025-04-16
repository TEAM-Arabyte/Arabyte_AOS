package com.konkuk.arabyte_aos.presentation.ui.review.navigation

import android.R.attr.defaultValue
import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.konkuk.arabyte_aos.presentation.type.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.review.ReviewRoute

fun NavController.navigationReview(
    categoryType: ArabyteCategoryType?,
) {
    val category = categoryType?.name ?: ""
    val route = "${ReviewRoute.ROUTE}/$category"
    navigateBottomMain(route)
}

fun NavGraphBuilder.reviewNavGraph(
    paddingValues: PaddingValues,
    // navigateToReviewDetailScreen : () -> Unit
) {
    composable(
        route = ReviewRoute.ROUTE_WITH_ARGUMENT,
        arguments =
            listOf(
                navArgument(ReviewRoute.ARGUMENT) {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                },
            ),
    ) { backStackEntry ->
        val categoryString = backStackEntry.arguments?.getString(ReviewRoute.ARGUMENT)
        val categoryType =
            runCatching {
                ArabyteCategoryType.valueOf(categoryString ?: "")
            }.getOrNull()
        ReviewRoute(
            paddingValues = paddingValues,
            categoryType = categoryType,
        )
    }
}

object ReviewRoute {
    const val ROUTE = "Review"
    const val ARGUMENT = "CategoryType"
    const val ROUTE_WITH_ARGUMENT = "$ROUTE/{$ARGUMENT}"
}
