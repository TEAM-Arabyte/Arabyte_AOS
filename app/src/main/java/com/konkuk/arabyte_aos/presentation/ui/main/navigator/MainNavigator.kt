package com.konkuk.arabyte_aos.presentation.ui.main.navigator

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
import com.konkuk.arabyte_aos.presentation.ui.login.navigation.navigationLogin
import com.konkuk.arabyte_aos.presentation.ui.mypage.navigation.navigationMyPage
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.navigation.navigationNoticeBoard
import com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.navigation.navigationNoticeBoardDetail
import com.konkuk.arabyte_aos.presentation.ui.onboarding.navigation.navigationOnboarding
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.navigation.navigationReviewDetail
import com.konkuk.arabyte_aos.presentation.ui.reviewlist.navigation.navigationReviewList
import com.konkuk.arabyte_aos.presentation.ui.signup.navigation.navigationSignUp

class MainNavigator(
    val navHostController: NavHostController,
) {
    private val currentDestination: NavDestination?
        @Composable get() = navHostController.currentBackStackEntryAsState().value?.destination
    private val currentRoute: String?
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
            MainNavigationBarItemType.REVIEW -> navHostController.navigationReviewList(categoryType = null)
            MainNavigationBarItemType.NOTICEBOARD -> navHostController.navigationNoticeBoard()
            MainNavigationBarItemType.MYPAGE -> navHostController.navigationMyPage()
        }
    }

    fun navigateToReviewList(arabyteCategoryType: ArabyteCategoryType?) {
        navHostController.navigationReviewList(categoryType = arabyteCategoryType)
    }

    fun navigateToNoticeBoard() {
        navHostController.navigationNoticeBoard()
    }

    fun navigateToHome() {
        navHostController.navigationHome()
    }

    fun navigateToSignUp() {
        navHostController.navigationSignUp()
    }

    fun navigateToOnboarding() {
        navHostController.navigationOnboarding()
    }

    fun navigateToReviewDetail() {
        navHostController.navigationReviewDetail()
    }

    fun navigateToNoticeBoardDetail(articleId : Long) {
        navHostController.navigationNoticeBoardDetail(articleId = articleId)
    }

    fun navigateToLogin() {
        navHostController.navigationLogin()
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
