package com.konkuk.arabyte_aos.presentation.ui.main.navigator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.konkuk.arabyte_aos.presentation.ui.home.navigation.homeNavGraph
import com.konkuk.arabyte_aos.presentation.ui.login.navigation.loginNavGraph
import com.konkuk.arabyte_aos.presentation.ui.mypage.navigation.myPageNavGraph
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.navigation.noticeboardNavGraph
import com.konkuk.arabyte_aos.presentation.ui.onboarding.navigation.onboardingNavGraph
import com.konkuk.arabyte_aos.presentation.ui.review.navigation.reviewNavGraph
import com.konkuk.arabyte_aos.presentation.ui.signup.navigation.signUpNavGraph
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navigator: MainNavigator,
    paddingValues: PaddingValues,
) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(ArabyteTheme.colors.white),
    ) {
        NavHost(
            navController = navigator.navHostController,
            startDestination = navigator.startDestination,
        ) {
            loginNavGraph(
                paddingValues = paddingValues,
                navigateToHome = navigator::navigateToHome,
                navigateSignUp = navigator::navigateToSignUp
            )
            homeNavGraph(
                paddingValues = paddingValues,
                navigateToReviewList = navigator::navigateToReview,
                navigateToNoticeBoard = navigator::navigateToNoticeBoard,
            )
            reviewNavGraph(
                paddingValues = paddingValues,
            )
            noticeboardNavGraph(
                paddingValues = paddingValues,
            )
            myPageNavGraph(
                paddingValues = paddingValues,
            )
            signUpNavGraph(
                paddingValues = paddingValues,
                navigateToOnboarding = navigator::navigateToOnboarding
            )
            onboardingNavGraph(
                paddingValues = paddingValues,
                navigateToHome = navigator::navigateToHome
            )
        }
    }
}
