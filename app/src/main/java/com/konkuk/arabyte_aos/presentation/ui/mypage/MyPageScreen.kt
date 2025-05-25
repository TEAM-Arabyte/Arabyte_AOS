package com.konkuk.arabyte_aos.presentation.ui.mypage

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
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
import com.konkuk.arabyte_aos.presentation.ui.mypage.component.MyPageContractView
import com.konkuk.arabyte_aos.presentation.ui.mypage.component.MyPageProfileRow
import com.konkuk.arabyte_aos.presentation.ui.mypage.component.MyPageProfileView
import com.konkuk.arabyte_aos.presentation.util.WebViewUrl.PRIVACY_POLICY_URL
import com.konkuk.arabyte_aos.presentation.util.WebViewUrl.SERVICE_RULES_URL
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
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

    val launcher = rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        uri?.let {
            myPageViewModel.setEvent(MyPageContract.MyPageEvent.SetContractImageUrl(it.toString()))
        }
    }

    LaunchedEffect(Unit) {
        myPageViewModel.setEvent(MyPageContract.MyPageEvent.GetMyInfo)
    }

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
        changeMyContractViewVisible = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.ChangeMyContractViewVisible) },
        changeAddContractViewVisible = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.ChangeAddContractViewVisible) },
        onCompanyNameValueChanged = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.CompanyNameValueChanged(it)) },
        galleryPickButtonClicked = { launcher.launch("image/*") },
        enrollButtonClicked = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.EnrollContract) }
    )
}

@Composable
fun MyPageScreen(
    paddingValues: PaddingValues,
    withDrawClicked: () -> Unit,
    logoutClicked: () -> Unit,
    changeDialogVisible: () -> Unit,
    changeUserProfileVisible: () -> Unit,
    changeWebViewVisible: () -> Unit,
    setWebViewUrl: (String) -> Unit,
    changeMyContractViewVisible: () -> Unit,
    changeAddContractViewVisible: () -> Unit,
    onCompanyNameValueChanged: (String) -> Unit,
    galleryPickButtonClicked: () -> Unit,
    enrollButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
    uiState: MyPageContract.MyPageUiState = MyPageContract.MyPageUiState(),
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .roundedBackgroundWithPadding(
                        backgroundColor = ArabyteTheme.colors.lightBlue,
                        cornerRadius = 7.dp,
                        padding = PaddingValues(horizontal = 11.dp, vertical = 15.dp)
                    ).noRippleClickable {
                        changeMyContractViewVisible()
                    }, verticalAlignment = Alignment.CenterVertically
            )
            {
                Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_auth_check_16), tint = Color.Unspecified, contentDescription = null)
                Spacer(modifier = Modifier.width(7.dp))
                Text(text = "나의 근로계약서", style = ArabyteTheme.typography.bodySemi13, color = ArabyteTheme.colors.mainBlue)
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_arrow_right_15), tint = Color.Unspecified, contentDescription = null)
            }
            Spacer(modifier = Modifier.height(19.dp))
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
        if (uiState.myContractViewVisible) {
            MyPageContractView(
                backButtonClicked = changeMyContractViewVisible,
                changeAddContractViewVisible = changeAddContractViewVisible,
                onCompanyNameValueChanged = onCompanyNameValueChanged,
                galleryPickButtonClicked = galleryPickButtonClicked,
                contractList = uiState.myContractList,
                companyName = uiState.companyName,
                contractImageUri = uiState.contractImageUri,
                addContractViewVisible = uiState.addContractViewVisible,
                enrollButtonClicked = enrollButtonClicked
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
            changeMyContractViewVisible = {},
            changeAddContractViewVisible = {},
            onCompanyNameValueChanged = {},
            galleryPickButtonClicked = {},
            enrollButtonClicked = {},
        )
    }
}
