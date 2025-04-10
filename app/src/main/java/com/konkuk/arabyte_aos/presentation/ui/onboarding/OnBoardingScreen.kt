package com.konkuk.arabyte_aos.presentation.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCareerTextFieldType
import com.konkuk.arabyte_aos.presentation.type.view.OnboardingType
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLargeButton
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteCareerTextField
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme


@Composable
fun OnBoardingRoute(modifier: Modifier = Modifier, innerPaddingValues: PaddingValues = PaddingValues(0.dp)) {
    OnBoardingScreen(innerPaddingValues = innerPaddingValues)
}


@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier, innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    onboardingType: OnboardingType = OnboardingType.FIRST
) {
    val horizontalModifier = Modifier.padding(horizontal = 16.dp)
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ArabyteTheme.colors.white)
            .padding(innerPaddingValues)
    ) {
        Row(modifier = horizontalModifier) {
            Icon(imageVector = ImageVector.vectorResource(onboardingType.pageIconRes), contentDescription = null)
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "건너뛰기", style = ArabyteTheme.typography.bodySemi15, color = ArabyteTheme.colors.gray03)
        }
        Spacer(modifier = Modifier.height(21.dp))
        Text(modifier = horizontalModifier, text = stringResource(onboardingType.titleStringRes), style = ArabyteTheme.typography.titleBold18, color = ArabyteTheme.colors.black)
        Spacer(modifier = Modifier.height(4.dp))
        Text(modifier = horizontalModifier, text = stringResource(onboardingType.descriptionStringRes), style = ArabyteTheme.typography.bodySemi13, color = ArabyteTheme.colors.gray05)
        Spacer(modifier = Modifier.height(68.dp))
        Row(modifier = horizontalModifier) {
            ArabyteCareerTextField(
                placeholder = "0",
                text = year,
                onValueChange = { newText ->
                    year = newText
                },
            )
            Spacer(modifier = Modifier.width(17.dp))
            ArabyteCareerTextField(
                placeholder = "0",
                text = month,
                careerTextFieldType = ArabyteCareerTextFieldType.MONTH,
                onValueChange = { newText ->
                    month = newText
                },
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        ArabyteLargeButton(
            enabled = uiState.buttonEnabled,
            buttonText = "다음",
            buttonClicked = completeButtonClicked,
        )
    }
}

@Preview
@Composable
private fun OnBoardingScreenPreview() {
    OnBoardingScreen()
}
