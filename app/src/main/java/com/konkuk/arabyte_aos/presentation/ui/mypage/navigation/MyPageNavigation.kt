package com.konkuk.arabyte_aos.presentation.ui.mypage.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.konkuk.arabyte_aos.presentation.ui.mypage.MyPageRoute

fun NavController.navigationMyPage() {
    navigate(
        route = MyPageRoute.ROUTE,
    ) {
        popUpTo(graph.startDestinationId) { inclusive = false }
        launchSingleTop = true
    }
}

fun NavGraphBuilder.myPageNavGraph(
    paddingValues: PaddingValues,
) {
    composable(route = MyPageRoute.ROUTE) {
        MyPageRoute(
            paddingValues = paddingValues,
        )
    }
}

object MyPageRoute {
    const val ROUTE = "MyPage"
}
