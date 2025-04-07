package com.konkuk.arabyte_aos.presentation.ui.login

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
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
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
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
    LoginScreen(modifier = modifier, innerPaddingValues = innerPaddingValues) {
        setLayoutLoginKakaoClickListener(context = context, callback = callback)
    }
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    loginButtonClicked: () -> Unit,
) {
    Box(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = arabyteColors.mainBlue)
                .padding(innerPaddingValues),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(207f))
            Text(
                text = stringResource(R.string.splash_service_description),
                style = ArabyteTheme.typography.bodyMed15,
                textAlign = TextAlign.Center,
                color = ArabyteTheme.colors.white,
            )
            Spacer(modifier = Modifier.weight(459f))
        }
        Row(
            modifier =
                Modifier
                    .align(Alignment.BottomCenter)
                    .padding(start = 16.dp, end = 16.dp, bottom = 39.dp)
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
                text = stringResource(R.string.login_kakao_login_text),
                style = ArabyteTheme.typography.bodySemi17,
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    ArabyteAOSTheme {
        LoginScreen(loginButtonClicked = {})
    }
}
