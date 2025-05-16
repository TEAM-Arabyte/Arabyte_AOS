package com.konkuk.arabyte_aos.presentation.ui.noticeboard.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.NoticeBoardListRoute

fun NavController.navigationNoticeBoard() {
    navigateBottomMain(NoticeBoardRoute.ROUTE)
}

fun NavGraphBuilder.noticeboardNavGraph(
    paddingValues: PaddingValues,
    navigateToNoticeBoardDetail: (articleId: Long) -> Unit,
) {
    composable(route = NoticeBoardRoute.ROUTE) {
        NoticeBoardListRoute(
            innerPaddingValues = paddingValues,
            navigateToNoticeBoardDetail = { articleId ->
                navigateToNoticeBoardDetail(articleId)
            },
        )
    }
}

object NoticeBoardRoute {
    const val ROUTE = "NoticeBoard"
}
