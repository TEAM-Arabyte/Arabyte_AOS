package com.konkuk.arabyte_aos.presentation.ui.onboarding.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.type.view.OnboardingType
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme

@Composable
fun OnboardingPageChip(
    modifier: Modifier = Modifier,
    onboardingType: OnboardingType = OnboardingType.FIRST,
) {
    Row {
        OnboardingNumberChip(numberResId = R.integer.onboarding_number_1, isCompleted = true)
        OnboardingNumberChip(numberResId = R.integer.onboarding_number_2, isCompleted = (onboardingType == OnboardingType.SECOND))
    }
}

@Preview
@Composable
private fun OnboardingPageChipPreview() {
    ArabyteAOSTheme {
        Column {
            OnboardingPageChip(onboardingType = OnboardingType.FIRST)
            OnboardingPageChip(onboardingType = OnboardingType.SECOND)
        }
    }
}
