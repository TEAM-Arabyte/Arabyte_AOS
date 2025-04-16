package com.konkuk.arabyte_aos.presentation.ui.noticeboard.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.NoticeBoardScreen

fun NavController.navigationNoticeBoard() {
    navigateBottomMain(NoticeBoardRoute.ROUTE)
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
