package com.konkuk.arabyte_aos.presentation.ui.mypage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.konkuk.arabyte_aos.BuildConfig
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.model.Gender
import com.konkuk.arabyte_aos.presentation.ui.component.dialog.ArabyteTwoButtonDialog
import com.konkuk.arabyte_aos.presentation.ui.component.view.ArabyteWebView
import com.konkuk.arabyte_aos.presentation.ui.mypage.component.MyPageClickableText
import com.konkuk.arabyte_aos.presentation.ui.mypage.component.MyPageProfileRow
import com.konkuk.arabyte_aos.presentation.ui.mypage.component.MyPageProfileView
import com.konkuk.arabyte_aos.presentation.util.WebViewUrl.PRIVACY_POLICY_URL
import com.konkuk.arabyte_aos.presentation.util.WebViewUrl.SERVICE_RULES_URL
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun MyPageRoute(
    paddingValues: PaddingValues,
    navigateToLogin: () -> Unit,
    myPageViewModel: MyPageViewModel = hiltViewModel(),
) {
    val uiState by myPageViewModel.uiState.collectAsStateWithLifecycle()

    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(myPageViewModel.sideEffect, lifecycleOwner) {
        myPageViewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is MyPageContract.MyPageSideEffect.NavigateToLogin -> navigateToLogin()
                }
            }
    }

    MyPageScreen(
        paddingValues = paddingValues,
        uiState = uiState,
        withDrawClicked = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.WithDrawClicked) },
        changeDialogVisible = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.ChangeDialogVisible) },
        changeUserProfileVisible = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.ChangeUserProfileVisible) },
        logoutClicked = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.LogoutClicked) },
        changeWebViewVisible = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.ChangeWebViewVisible) },
        setWebViewUrl = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.SetWebViewUrl(it)) },
    )
}

@Composable
fun MyPageScreen(
    paddingValues: PaddingValues,
    withDrawClicked: () -> Unit,
    logoutClicked: () -> Unit,
    changeDialogVisible: () -> Unit,
    changeUserProfileVisible: () -> Unit,
    modifier: Modifier = Modifier,
    uiState: MyPageContract.MyPageUiState = MyPageContract.MyPageUiState(),
    changeWebViewVisible: () -> Unit,
    setWebViewUrl: (String) -> Unit,
) {
    val defaultProfileRes =
        when (uiState.userProfile.gender) {
            Gender.MALE -> R.drawable.img_profile_default_male
            Gender.FEMALE -> R.drawable.img_profile_default_female
            Gender.ANONYMITY -> R.drawable.img_profile_default_anonymity
        }

    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.white)
                .padding(paddingValues),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(26.dp))
            MyPageProfileRow(
                profileImage = "",
                defaultProfileRes = defaultProfileRes,
                nickname = uiState.userProfile.userName,
                onClick = changeUserProfileVisible,
            )
            HorizontalDivider(thickness = 8.dp, color = ArabyteTheme.colors.gray01)
            MyPageClickableText(text = "내가 쓴 글", clickable = changeDialogVisible)
            MyPageClickableText(text = "내가 좋아요한 글", clickable = changeDialogVisible)
            HorizontalDivider(thickness = 8.dp, color = ArabyteTheme.colors.gray01)
            Row(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 20.dp),
            ) {
                Text(text = "서비스 버전", style = ArabyteTheme.typography.bodyMed15, color = ArabyteTheme.colors.black)
                Spacer(modifier = Modifier.weight(1f))
                Text(text = "v${BuildConfig.VERSION_CODE}", style = ArabyteTheme.typography.bodyMed13, color = ArabyteTheme.colors.gray04)
            }
            MyPageClickableText(text = "서비스 이용약관", clickable = {
                setWebViewUrl(SERVICE_RULES_URL)
                changeWebViewVisible()
            })
            MyPageClickableText(text = "개인정보처리방침", clickable = {
                setWebViewUrl(PRIVACY_POLICY_URL)
                changeWebViewVisible()
            })
            MyPageClickableText(text = "로그아웃", clickable = logoutClicked, textColor = ArabyteTheme.colors.alertRed)

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "탈퇴하기",
                style = ArabyteTheme.typography.capSemi11,
                color = ArabyteTheme.colors.gray05,
                modifier =
                    Modifier
                        .padding(16.dp)
                        .noRippleClickable(withDrawClicked)
                        .align(Alignment.End),
            )
        }
        if (uiState.dialogVisible) {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(ArabyteTheme.colors.black.copy(alpha = 0.3f))
                        .noRippleClickable(changeDialogVisible),
                contentAlignment = Alignment.Center,
            ) {
                ArabyteTwoButtonDialog(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    title = "추후 업데이트 될 기능입니다.",
                    completeButtonText = stringResource(R.string.all_complete_button),
                    cancelButtonClicked = changeDialogVisible,
                    completeButtonClicked = {
                        changeDialogVisible()
                    },
                )
            }
        }
        if (uiState.userProfileVisible) {
            MyPageProfileView(
                profileImageRes = "",
                defaultProfileRes = defaultProfileRes,
                userProfile = uiState.userProfile,
                backButtonClicked = changeUserProfileVisible,
            )
        }
        if (uiState.webViewVisible) {
            ArabyteWebView(
                url = uiState.wevViewUrl,
                onClose = changeWebViewVisible,
            )
        }
    }
}

@Preview
@Composable
private fun MyPageScreenPreview() {
    ArabyteAOSTheme {
        MyPageScreen(
            withDrawClicked = {},
            paddingValues = PaddingValues(0.dp),
            logoutClicked = {},
            changeDialogVisible = {},
            changeUserProfileVisible = {},
            changeWebViewVisible = {},
            setWebViewUrl = {},
        )
    }
}
