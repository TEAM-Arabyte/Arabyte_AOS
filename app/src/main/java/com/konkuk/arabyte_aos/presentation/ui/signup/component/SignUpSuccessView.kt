package com.konkuk.arabyte_aos.presentation.ui.signup.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteNormalButton
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun SignUpSuccessView(
    nickname: String,
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    navigateToOnboarding: () -> Unit = {},
) {
    val styledText =
        buildAnnotatedString {
            withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
                append(nickname)
            }
            append("님\n가입을 축하드려요!")
        }
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.white)
                .padding(innerPaddingValues)
                .padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.weight(101f))
        Text(
            text = styledText,
            style = ArabyteTheme.typography.titleBold20,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
        )
        Spacer(modifier = Modifier.height(46.dp))
        Image(
            painter = painterResource(R.drawable.img_signup_success),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.height(17.dp))
        ArabyteNormalButton(
            buttonText = stringResource(R.string.sign_up_success_button),
            buttonClicked = navigateToOnboarding,
        )
        Spacer(modifier = Modifier.weight(174f))
    }
}

@Preview
@Composable
private fun SignUpSuccessViewPreview() {
    ArabyteAOSTheme {
        SignUpSuccessView(nickname = "나야 알바")
    }
}
