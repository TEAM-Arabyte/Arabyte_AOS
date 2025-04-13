package com.konkuk.arabyte_aos.presentation.ui.onboarding.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLargeButton
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun OnboardingSuccessView(
    completeButtonClicked: () -> Unit = {},
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val horizontalModifier = Modifier.padding(horizontal = 16.dp)
    val fullText = stringResource(R.string.onboarding_title)
    val highlight = "접근 권한"
    val highlightedText =
        buildAnnotatedString {
            val start = fullText.indexOf(highlight)
            val end = start + highlight.length
            append(fullText)
            if (start >= 0) {
                addStyle(
                    style = SpanStyle(color = ArabyteTheme.colors.mainBlue),
                    start = start,
                    end = end,
                )
            }
        }

    Column(
        modifier
            .fillMaxSize()
            .background(color = ArabyteTheme.colors.white)
            .padding(innerPaddingValues),
    ) {
        Spacer(modifier = Modifier.height(88.dp))
        Text(
            modifier = horizontalModifier.fillMaxWidth(),
            text = highlightedText,
            style = ArabyteTheme.typography.titleBold18,
            color = ArabyteTheme.colors.black,
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.height(46.dp))
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 20.dp)
                    .border(width = 1.dp, color = ArabyteTheme.colors.gray01, shape = RoundedCornerShape(16.dp))
                    .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_all_alert_30),
                tint = Color.Unspecified,
                modifier =
                    Modifier
                        .background(color = ArabyteTheme.colors.gray01, shape = CircleShape)
                        .size(40.dp),
                contentDescription = null,
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(text = stringResource(R.string.onboarding_push_alarm_title), style = ArabyteTheme.typography.bodyBold15, color = ArabyteTheme.colors.black)
                Text(text = stringResource(R.string.onboarding_push_alarm_description), style = ArabyteTheme.typography.bodySemi13, color = ArabyteTheme.colors.gray05)
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ArabyteLargeButton(
            enabled = true,
            buttonText = stringResource(R.string.onboarding_confirm_button),
            buttonClicked = completeButtonClicked,
        )
    }
}

@Preview
@Composable
private fun OnboardingSuccessViewPreview() {
    ArabyteAOSTheme { OnboardingSuccessView() }
}
