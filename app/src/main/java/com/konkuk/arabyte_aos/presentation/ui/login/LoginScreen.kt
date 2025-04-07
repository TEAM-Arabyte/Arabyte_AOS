package com.konkuk.arabyte_aos.presentation.ui.login

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

fun setLayoutLoginKakaoClickListener(
    context: Context,
    callback: (OAuthToken?, Throwable?) -> Unit,
) {
    if (UserApiClient.instance.isKakaoTalkLoginAvailable(context)) {
        UserApiClient.instance.loginWithKakaoTalk(context, callback = callback)
    } else {
        UserApiClient.instance.loginWithKakaoAccount(context, callback = callback)
    }
}

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    viewModel: LoginViewModel = hiltViewModel(),
) {
    val context = LocalContext.current

    val callback: (OAuthToken?, Throwable?) -> Unit = { oAuthToken, _ ->
        if (oAuthToken != null) {
            DebugLog.d("LoginRoute", "OAuthToken_AccessToken= ${oAuthToken.accessToken}")
            viewModel.setKakaoAccessToken(oAuthToken.accessToken)
        }
    }
    LoginScreen(modifier = modifier,innerPaddingValues = innerPaddingValues) {
        setLayoutLoginKakaoClickListener(context = context, callback = callback)
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    loginButtonClicked: () -> Unit,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = arabyteColors.mainBlue)
                .padding(innerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(207.dp))
        Text(
            text = "당신의 알바 선택을 더 똑똑하게,\n알바의 모든것을 알아보세요",
            color = arabyteColors.white,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier =
                Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .roundedBackgroundWithPadding(
                        backgroundColor = arabyteColors.kakaoYellow,
                        cornerRadius = 6.dp,
                    )
                    .noRippleClickable { loginButtonClicked() },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_login_kakao_18),
                contentDescription = null,
                modifier = Modifier.padding(vertical = 18.dp),
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = "카카오 계정으로 시작하기",
            )
        }
        Spacer(modifier = Modifier.height(39.dp))
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    LoginScreen(loginButtonClicked = {})
}
