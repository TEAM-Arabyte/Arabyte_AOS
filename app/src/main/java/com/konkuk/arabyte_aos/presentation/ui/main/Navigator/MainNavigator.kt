package com.konkuk.arabyte_aos.presentation.ui.main.Navigator

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.konkuk.arabyte_aos.presentation.type.MainNavigationBarItemType
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCategoryType
import com.konkuk.arabyte_aos.presentation.ui.home.navigation.navigationHome
import com.konkuk.arabyte_aos.presentation.ui.login.navigation.LoginRoute
import com.konkuk.arabyte_aos.presentation.ui.mypage.navigation.navigationMyPage
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.navigation.navigationNoticeBoard
import com.konkuk.arabyte_aos.presentation.ui.review.navigation.navigationReview

class MainNavigator(
    val navHostController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination
    val currentRoute: String?
        @Composable get() = currentDestination?.route?.substringBefore("/")
    val currentMainNavigationBarItem: MainNavigationBarItemType?
        @Composable get() =
            MainNavigationBarItemType.entries.find {
                it.route.toString() == currentRoute
            }

    val startDestination = LoginRoute.ROUTE

    fun navigateMainNavigation(mainNavigationBarItemType: MainNavigationBarItemType) {
        when (mainNavigationBarItemType) {
            MainNavigationBarItemType.HOME -> navHostController.navigationHome()
            MainNavigationBarItemType.REVIEW -> navHostController.navigationReview(categoryType = null)
            MainNavigationBarItemType.NOTICEBOARD -> navHostController.navigationNoticeBoard()
            MainNavigationBarItemType.MYPAGE -> navHostController.navigationMyPage()
        }
    }

    fun navigateToHome() {
        navHostController.navigationHome()
    }

    fun navigateToReview(arabyteCategoryType: ArabyteCategoryType?) {
        navHostController.navigationReview(categoryType = arabyteCategoryType)
    }

    fun navigateToNoticeBoard() {
        navHostController.navigationNoticeBoard()
    }

    fun popBackStack() {
        if (navHostController.previousBackStackEntry != null) {
            navHostController.popBackStack()
        }
    }

    @Composable
    fun showBottomBar(): Boolean {
        return currentMainNavigationBarItem != null
    }
}

@Composable
fun rememberMainNavigator(
    navHostController: NavHostController = rememberNavController(),
): MainNavigator =
    remember(navHostController) {
        MainNavigator(navHostController = navHostController)
    }
