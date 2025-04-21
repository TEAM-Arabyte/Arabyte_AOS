package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.NoticeBoardDetailRoute

fun NavController.navigationNoticeBoardDetail() {
    navigateBottomMain(NoticeBoardDetailRoute.ROUTE)
}

fun NavGraphBuilder.noticeboarddetailNavGraph(
    paddingValues: PaddingValues,
) {
    composable(route = NoticeBoardDetailRoute.ROUTE) {
        NoticeBoardDetailRoute(
            innerPaddingValues = paddingValues,
        )
    }
}

object NoticeBoardDetailRoute {
    const val ROUTE = "NoticeBoardDetail"
}
