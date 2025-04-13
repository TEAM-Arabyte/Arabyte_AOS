package com.konkuk.arabyte_aos.presentation.ui.onboarding

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.flowlayout.FlowRow
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteCareerTextFieldType
import com.konkuk.arabyte_aos.presentation.type.view.OnboardingType
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteChipButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLargeButton
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteCareerTextField
import com.konkuk.arabyte_aos.presentation.ui.onboarding.component.OnboardingPageChip
import com.konkuk.arabyte_aos.presentation.ui.onboarding.component.OnboardingSuccessView
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun OnBoardingRoute(
    viewModel: OnboardingViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState.loadState) {
        LoadState.Idle ->
            OnBoardingScreen(
                innerPaddingValues = innerPaddingValues,
                uiState = uiState,
                careerYearTextChanged = { year ->
                    viewModel.setEvent(OnboardingContract.OnboardingEvent.ChangeCareerYearValue(year))
                },
                careerMonthTextChanged = { month ->
                    viewModel.setEvent(OnboardingContract.OnboardingEvent.ChangeCareerMonthValue(month))
                },
                completeButtonClicked = {
                    viewModel.setEvent(OnboardingContract.OnboardingEvent.CompleteButtonClicked)
                },
                categoryChipClicked = { category ->
                    viewModel.setEvent(OnboardingContract.OnboardingEvent.SelectJobCategory(category))
                },
            )
        LoadState.Success -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                // Android 13 이상 → 알림 권한 요청 화면 보여줌
                OnboardingSuccessView(
                    innerPaddingValues = innerPaddingValues,
                    completeButtonClicked = {},
                )
            } else {
            }
        }
        else -> Unit
    }
}

@Composable
fun OnBoardingScreen(
    modifier: Modifier = Modifier,
    uiState: OnboardingContract.OnboardingUiState = OnboardingContract.OnboardingUiState(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    careerYearTextChanged: (String) -> Unit = {},
    careerMonthTextChanged: (String) -> Unit = {},
    completeButtonClicked: () -> Unit = {},
    categoryChipClicked: (String) -> Unit = {},
) {
    val horizontalModifier = Modifier.padding(horizontal = 16.dp)
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.white)
                .padding(innerPaddingValues),
    ) {
        Spacer(modifier = Modifier.height(35.dp))
        Row(modifier = horizontalModifier, verticalAlignment = Alignment.CenterVertically) {
            OnboardingPageChip(onboardingType = uiState.onboardingType)
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = stringResource(R.string.onboarding_skip_button),
                style = ArabyteTheme.typography.bodySemi15,
                color = ArabyteTheme.colors.gray03,
                modifier = Modifier.noRippleClickable { completeButtonClicked() },
            )
        }
        Spacer(modifier = Modifier.height(21.dp))
        Text(modifier = horizontalModifier, text = stringResource(uiState.onboardingType.titleStringRes), style = ArabyteTheme.typography.titleBold18, color = ArabyteTheme.colors.black)
        Spacer(modifier = Modifier.height(4.dp))
        Text(modifier = horizontalModifier, text = stringResource(uiState.onboardingType.descriptionStringRes), style = ArabyteTheme.typography.bodySemi13, color = ArabyteTheme.colors.gray05)
        if (uiState.onboardingType == OnboardingType.FIRST) {
            Spacer(modifier = Modifier.height(88.dp))

            Row(modifier = horizontalModifier) {
                ArabyteCareerTextField(
                    placeholder = stringResource(R.string.onboarding_career_text_field_placeholder),
                    text = uiState.careerYear,
                    careerTextFieldType = ArabyteCareerTextFieldType.YEAR,
                    onValueChange = { year ->
                        careerYearTextChanged(year)
                    },
                )
                Spacer(modifier = Modifier.width(17.dp))
                ArabyteCareerTextField(
                    placeholder = stringResource(R.string.onboarding_career_text_field_placeholder),
                    text = uiState.careerMonth,
                    careerTextFieldType = ArabyteCareerTextFieldType.MONTH,
                    onValueChange = { month ->
                        careerMonthTextChanged(month)
                    },
                )
            }
        } else {
            Spacer(modifier = Modifier.height(45.dp))
            FlowRow(
                modifier = horizontalModifier,
                mainAxisSpacing = 10.dp,
                crossAxisSpacing = 10.dp,
            ) {
                ArabyteJobCategory.entries.forEach { category ->
                    ArabyteChipButton(
                        buttonText = category.label,
                        enabled = uiState.selectedCategories.contains(category.label),
                        buttonClicked = {
                            categoryChipClicked(category.label)
                        },
                    )
                }
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ArabyteLargeButton(
            enabled = uiState.buttonEnabled,
            buttonText = stringResource(R.string.all_next_button),
            buttonClicked = completeButtonClicked,
        )
    }
}

@Preview
@Composable
private fun OnBoardingScreenPreview() {
    ArabyteAOSTheme { OnBoardingScreen() }
}
