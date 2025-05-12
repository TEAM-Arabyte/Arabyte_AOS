package com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.navigation.navigateBottomMain
import com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite.NoticeBoardWriteRoute

fun NavController.navigationNoticeBoardWrite() {
    navigateBottomMain(NoticeBoardWriteRoute.ROUTE)
}

fun NavGraphBuilder.noticeBoardWrite(
    paddingValues: PaddingValues,
    popBackStack: () -> Unit,
    navigateToReviewList: () -> Unit,
) {
    composable(route = NoticeBoardWriteRoute.ROUTE) {
        NoticeBoardWriteRoute(
            navigateToBack = popBackStack,
            navigateToNoticeBoardList = navigateToReviewList,
            paddingValues = paddingValues,
        )
    }
}

object NoticeBoardWriteRoute {
    const val ROUTE = "NoticeBoardWrite"
}
