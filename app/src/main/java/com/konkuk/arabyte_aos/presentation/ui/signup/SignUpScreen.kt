package com.konkuk.arabyte_aos.presentation.ui.signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.presentation.type.view.SignUpType
import com.konkuk.arabyte_aos.presentation.ui.component.bottomsheet.ArabyteLocationBottomSheet
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLargeButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLocationButton
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteNormalTextField
import com.konkuk.arabyte_aos.presentation.ui.signup.component.SignUpAgeGrid
import com.konkuk.arabyte_aos.presentation.ui.signup.component.SignUpGenderRow
import com.konkuk.arabyte_aos.presentation.ui.signup.component.SignUpSuccessView
import com.konkuk.arabyte_aos.presentation.util.SignUp.FIRST_KEYWORD
import com.konkuk.arabyte_aos.presentation.util.SignUp.ONE
import com.konkuk.arabyte_aos.presentation.util.SignUp.SECOND_KEYWORD
import com.konkuk.arabyte_aos.presentation.util.SignUp.SLASH_TWO
import com.konkuk.arabyte_aos.presentation.util.SignUp.TWO_SLASH_TWO
import com.konkuk.arabyte_aos.presentation.util.SignUp.errorMessageList
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun SignUpRoute(
    navigateToOnboarding: () -> Unit,
    viewModel: SignUpViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(uiState.selectedAge, uiState.selectedGender, uiState.location) {
        if (uiState.selectedAge != null && uiState.selectedGender != null && uiState.location.isNotEmpty()) {
            viewModel.setEvent(SignUpContract.SignUpEvent.CompleteButtonEnabled)
        }
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is SignUpContract.SignUpSideEffect.NavigateToOnboarding -> navigateToOnboarding()
                }
            }
    }

    LaunchedEffect(Unit) {
        viewModel.setEvent(SignUpContract.SignUpEvent.LoadSidoList)
    }

    when (uiState.loadState) {
        LoadState.Idle ->
            SignUpScreen(
                innerPaddingValues = innerPaddingValues,
                uiState = uiState,
                completeButtonClicked = {
                    viewModel.setEvent(SignUpContract.SignUpEvent.CompleteButtonClicked)
                },
                ageButtonClicked = { age ->
                    viewModel.setEvent(SignUpContract.SignUpEvent.AgeButtonClicked(age))
                },
                genderButtonClicked = { gender ->
                    viewModel.setEvent(SignUpContract.SignUpEvent.GenderButtonClicked(gender))
                },
                onNicknameValueChanged = { nickname ->
                    viewModel.setEvent(SignUpContract.SignUpEvent.NicknameValueChanged(nickname))
                },
                errorMessageList = errorMessageList,
                changeBottomSheetVisible = {
                    viewModel.setEvent(SignUpContract.SignUpEvent.ChangeLocationBottomSheetVisible)
                },
                bottomSheetCompleteButtonClicked = { location ->
                    viewModel.setEvent(SignUpContract.SignUpEvent.SetLocation(location))
                },
                sidoOnclick = { sido ->
                    viewModel.setEvent(SignUpContract.SignUpEvent.SelectSido(sido))
                },
                guOnclick = { gu ->
                    viewModel.setEvent(SignUpContract.SignUpEvent.SelectGu(gu))
                },
                dongOnclick = { dong ->
                    viewModel.setEvent(SignUpContract.SignUpEvent.SelectDong(dong))
                },
            )

        LoadState.Success ->
            SignUpSuccessView(nickname = uiState.nickname, innerPaddingValues = innerPaddingValues, navigateToOnboarding = {
                viewModel.setSideEffect(SignUpContract.SignUpSideEffect.NavigateToOnboarding)
            })

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
    onNicknameValueChanged: (String) -> Unit = {},
    errorMessageList: List<String> = emptyList(),
    changeBottomSheetVisible: () -> Unit = {},
    bottomSheetCompleteButtonClicked: (String) -> Unit = {},
    sidoOnclick: (LocationData) -> Unit = {},
    guOnclick: (LocationData) -> Unit = {},
    dongOnclick: (LocationData) -> Unit = {},
) {
    val horizontalModifier = Modifier.padding(horizontal = 16.dp)

    val titleRaw = stringResource(id = uiState.signUpType.titleStringRes)
    val keywordTitle =
        when (uiState.signUpType) {
            SignUpType.FIRST -> FIRST_KEYWORD
            SignUpType.SECOND -> SECOND_KEYWORD
        }

    val spanTitle =
        buildAnnotatedString {
            val parts = titleRaw.split(keywordTitle)
            append(parts[0])
            withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
                append(keywordTitle)
            }
            if (parts.size > 1) append(parts[1])
        }

    val spanPage =
        buildAnnotatedString {
            when (uiState.signUpType.pageText) {
                SignUpType.FIRST.pageText -> {
                    withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
                        append(ONE)
                    }
                    append(SLASH_TWO)
                }

                SignUpType.SECOND.pageText -> {
                    withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
                        append(TWO_SLASH_TWO)
                    }
                }
            }
        }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(color = ArabyteTheme.colors.white)
                    .padding(innerPaddingValues),
        ) {
            Spacer(modifier = Modifier.height(35.dp))
            Text(
                text = spanPage,
                modifier = horizontalModifier,
                style = ArabyteTheme.typography.titleBold18,
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = spanTitle,
                modifier = horizontalModifier,
                style = ArabyteTheme.typography.titleBold18,
            )
            Spacer(modifier = Modifier.height(35.dp))
            when (uiState.signUpType) {
                SignUpType.FIRST -> {
                    ArabyteNormalTextField(
                        modifier = horizontalModifier,
                        title = stringResource(R.string.sign_up_nickname),
                        textMaxLength = 10,
                        text = uiState.nickname,
                        onValueChange = { text ->
                            onNicknameValueChanged(text)
                        },
                        validationState = uiState.nicknameValidationState,
                        placeholder = stringResource(R.string.sign_up_nickname_placeholder),
                        errorMessageList = errorMessageList,
                    )
                }

                SignUpType.SECOND -> {
                    ArabyteLocationButton(
                        modifier = horizontalModifier,
                        onClicked = changeBottomSheetVisible,
                        location = uiState.location,
                        title = stringResource(R.string.sign_up_region),
                        isSelected = uiState.location.isNotEmpty(),
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
                    SignUpGenderRow(
                        modifier = horizontalModifier,
                        selectedGender = uiState.selectedGender,
                        onClick = { gender ->
                            genderButtonClicked(gender)
                        },
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            ArabyteLargeButton(
                enabled = uiState.buttonEnabled,
                buttonText = stringResource(uiState.signUpType.buttonTextStringRes),
                buttonClicked = { if (uiState.buttonEnabled) completeButtonClicked() },
            )
        }

        if (uiState.locationBottomSheetVisible) {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(ArabyteTheme.colors.black.copy(alpha = 0.3f))
                        .noRippleClickable { changeBottomSheetVisible() },
            )

            ArabyteLocationBottomSheet(
                modifier = Modifier.padding(bottom = innerPaddingValues.calculateBottomPadding()),
                bottomSheetClose = changeBottomSheetVisible,
                completeButtonClicked = { location ->
                    bottomSheetCompleteButtonClicked(location)
                    changeBottomSheetVisible()
                },
                selectedSido = uiState.selectedSido,
                sidoList = uiState.sidoList,
                sidoOnclick = { sido ->
                    sidoOnclick(sido)
                },
                selectedGu = uiState.selectedGu,
                guList = uiState.guList,
                guOnclick = { gu ->
                    guOnclick(gu)
                },
                selectedDong = uiState.selectedDong,
                dongList = uiState.dongList,
                dongOnclick = { dong ->
                    dongOnclick(dong)
                },
            )
        }
    }
}

@Preview
@Composable
private fun SignUpScreenPreview() {
    ArabyteAOSTheme { SignUpScreen() }
}
