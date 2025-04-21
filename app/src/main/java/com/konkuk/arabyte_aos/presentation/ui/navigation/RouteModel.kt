package com.konkuk.arabyte_aos.presentation.ui.navigation

sealed interface Route

sealed interface MainNavigationBarRoute : Route {
    data object Home : MainNavigationBarRoute

    data object Review : MainNavigationBarRoute

    data object NoticeBoard : MainNavigationBarRoute

    data object MyPage : MainNavigationBarRoute
}
