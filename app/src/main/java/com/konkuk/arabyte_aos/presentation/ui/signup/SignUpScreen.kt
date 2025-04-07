package com.konkuk.arabyte_aos.presentation.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.type.view.SignUpType
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLargeButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLocationButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteSmallButton
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteNormalTextField
import com.konkuk.arabyte_aos.presentation.ui.signup.component.SignUpAgeGrid
import com.konkuk.arabyte_aos.presentation.ui.signup.component.SignUpGenderRow
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun SignUpRoute(
    viewModel: SignUpViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp)
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState.loadState) {
        LoadState.Idle -> SignUpScreen(innerPaddingValues = innerPaddingValues, uiState = uiState,
            completeButtonClicked = {},
            ageButtonClicked = { age ->
                viewModel.setEvent(SignUpContract.SignUpEvent.AgeButtonClicked(age))
            },
            genderButtonClicked = { gender ->
                viewModel.setEvent(SignUpContract.SignUpEvent.GenderButtonClicked(gender))
            }
        )

        LoadState.Success -> {
            //TODO: 회원가입 성공 뷰
        }

        else -> Unit
    }

}

@Composable
fun SignUpScreen(
    modifier: Modifier = Modifier,
    uiState: SignUpContract.SignUpUiState = SignUpContract.SignUpUiState(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    completeButtonClicked: () -> Unit = {},
    ageButtonClicked: (String) -> Unit = {},
    genderButtonClicked: (String) -> Unit = {},
) {
    val horizontalModifier = Modifier.padding(horizontal = 16.dp)

    val titleRaw = stringResource(id = uiState.signUpType.titleStringRes)
    val keywordTitle = when (uiState.signUpType) {
        SignUpType.FIRST -> "닉네임"
        SignUpType.SECOND -> "간단한 정보"
    }

    val spanTitle = buildAnnotatedString {
        val parts = titleRaw.split(keywordTitle)
        append(parts[0])
        withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
            append(keywordTitle)
        }
        if (parts.size > 1) append(parts[1])
    }

    val spanPage = buildAnnotatedString {
        when (uiState.signUpType.pageText) {
            SignUpType.FIRST.pageText -> {
                withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
                    append("1")
                }
                append("/2")
            }

            SignUpType.SECOND.pageText -> {
                withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
                    append("2/2")
                }
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ArabyteTheme.colors.white)
            .padding(innerPaddingValues)
    ) {

        Spacer(modifier = Modifier.height(35.dp))
        Text(
            text = spanPage,
            modifier = horizontalModifier,
            style = ArabyteTheme.typography.titleBold18
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            text = spanTitle,
            modifier = horizontalModifier,
            style = ArabyteTheme.typography.titleBold18
        )
        Spacer(modifier = Modifier.height(35.dp))
        when (uiState.signUpType) {
            SignUpType.FIRST -> {
                ArabyteNormalTextField(
                    modifier = horizontalModifier,
                    title = stringResource(R.string.sign_up_nickname),
                    textMaxLength = 10,
                    placeholder = stringResource(R.string.sign_up_nickname_placeholder)
                )
            }

            SignUpType.SECOND -> {
                ArabyteLocationButton(
                    modifier = horizontalModifier,
                    title = stringResource(R.string.sign_up_region)
                )
                Spacer(modifier = Modifier.height(33.dp))
                SignUpAgeGrid(
                    modifier = horizontalModifier,
                    selectedAge = uiState.selectedAge,
                    onClick = { age ->
                        ageButtonClicked(age)
                    },
                )
                Spacer(modifier = Modifier.height(23.dp))
                SignUpGenderRow(modifier = horizontalModifier, onClick = { gender ->
                    genderButtonClicked(gender)
                })
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        ArabyteLargeButton(
            enabled = uiState.buttonEnabled,
            buttonText = stringResource(uiState.signUpType.buttonTextStringRes),
            buttonClicked = completeButtonClicked
        )
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    ArabyteAOSTheme { SignUpScreen() }
}
