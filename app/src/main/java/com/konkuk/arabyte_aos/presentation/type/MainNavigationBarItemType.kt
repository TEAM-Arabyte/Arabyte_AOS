package com.konkuk.arabyte_aos.presentation.type

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.navigation.MainNavigationBarRoute
import com.konkuk.arabyte_aos.presentation.ui.navigation.Route

enum class MainNavigationBarItemType(
    @DrawableRes val iconRes: Int,
    @StringRes val label: Int,
    val route: MainNavigationBarRoute,
) {
    HOME(
        iconRes = R.drawable.ic_tabbar_home_23,
        label = R.string.bottom_nav_home,
        route = MainNavigationBarRoute.Home,
    ),
    REVIEW(
        iconRes = R.drawable.ic_tabbar_review_23,
        label = R.string.bottom_nav_review,
        route = MainNavigationBarRoute.Review,
    ),
    NOTICEBOARD(
        iconRes = R.drawable.ic_tabbar_board_23,
        label = R.string.bottom_nav_notice_board,
        route = MainNavigationBarRoute.NoticeBoard,
    ),
    MYPAGE(
        iconRes = R.drawable.ic_tabbar_my_23,
        label = R.string.bottom_nav_my_page,
        route = MainNavigationBarRoute.MyPage,
    ),
    ;

    companion object {
        @Composable
        fun find(predicate: @Composable (MainNavigationBarRoute) -> Boolean): MainNavigationBarItemType? {
            return entries.find { predicate(it.route) }
        }

        @Composable
        fun contains(predicate: @Composable (Route) -> Boolean): Boolean {
            return entries.map { it.route }.any { predicate(it) }
        }
    }
}
