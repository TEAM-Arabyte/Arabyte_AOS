package com.konkuk.arabyte_aos.presentation.ui.noticeboard.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.NoticeBoardScreen

fun NavController.navigationNoticeBoard() {
    navigate(
        route = NoticeBoardRoute.ROUTE,
    ) {
        popUpTo(graph.startDestinationId) { inclusive = false }
        launchSingleTop = true
    }
}

fun NavGraphBuilder.noticeboardNavGraph(
    paddingValues: PaddingValues,
) {
    composable(route = NoticeBoardRoute.ROUTE) {
        NoticeBoardScreen(
            paddingValues = paddingValues,
        )
    }
}

object NoticeBoardRoute {
    const val ROUTE = "NoticeBoard"
}
