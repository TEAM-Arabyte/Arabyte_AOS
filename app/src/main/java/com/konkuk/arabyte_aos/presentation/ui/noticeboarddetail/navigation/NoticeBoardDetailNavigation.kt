package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.NoticeBoardDetailRoute

fun NavController.navigationNoticeBoardDetail(articleId: Long) {
    navigateBottomMain(NoticeBoardDetailRoute.routeWithArgument(articleId = articleId))
}

fun NavGraphBuilder.noticeBoarDetailNavGraph(
    navigateToBack: () -> Unit,
    paddingValues: PaddingValues,
) {
    composable(
        route = NoticeBoardDetailRoute.ROUTE_WITH_ARGUMENT,
        arguments =
            listOf(
                navArgument(NoticeBoardDetailRoute.ARGUMENT) {
                    type = NavType.LongType
                },
            ),
    ) { backStackEntry ->
        val articleId = backStackEntry.arguments?.getLong(NoticeBoardDetailRoute.ARGUMENT) ?: -1
        NoticeBoardDetailRoute(
            navigateToBack = navigateToBack,
            articleId = articleId,
            innerPaddingValues = paddingValues,
        )
    }
}

object NoticeBoardDetailRoute {
    const val ROUTE = "NoticeBoardDetail"
    const val ARGUMENT = "articleId"
    const val ROUTE_WITH_ARGUMENT = "$ROUTE/{$ARGUMENT}"

    fun routeWithArgument(articleId: Long): String = "$ROUTE/$articleId"
}
