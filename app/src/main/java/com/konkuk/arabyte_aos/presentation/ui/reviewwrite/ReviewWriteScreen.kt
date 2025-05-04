package com.konkuk.arabyte_aos.presentation.ui.reviewwrite

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.google.accompanist.flowlayout.FlowRow
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.model.NullableReviewRating
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.presentation.ui.component.bottomsheet.ArabyteLocationBottomSheet
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteChipButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLocationButton
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteNormalTextField
import com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component.ReviewWriteEvaluation
import com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component.ReviewWritingRating
import com.konkuk.arabyte_aos.presentation.util.context.arabyteToastMessage
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewWriteRoute(
    modifier: Modifier = Modifier,
    popBackStack: () -> Unit,
    navigateToReviewList: () -> Unit,
    viewModel: ReviewWriteViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current
    val context = LocalContext.current

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is ReviewWriteContract.ReviewWriteSideEffect.NavigateToReviewList -> popBackStack()

                    is ReviewWriteContract.ReviewWriteSideEffect.PopBackStack -> navigateToReviewList()

                    is ReviewWriteContract.ReviewWriteSideEffect.ShowServerErrorToast ->
                        context.arabyteToastMessage(
                            messageResId = R.string.all_toast_server_error,
                        )

                    is ReviewWriteContract.ReviewWriteSideEffect.ShowDataValidErrorToast ->
                        context.arabyteToastMessage(
                            messageResId = R.string.review_write_data_valid_error,
                        )
                }
            }
    }

    LaunchedEffect(Unit) {
        viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.LoadSidoList)
    }

    ReviewWriteScreen(
        modifier = modifier,
        uiState = uiState,
        innerPaddingValues = innerPaddingValues,
        categoryChipClicked = { job ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.JobCategoryClicked(job))
        },
        onCompanyValueChanged = { company ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.CompanyTextChanged(company))
        },
        changeLocationBottomSheetVisible = {
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.ChangeLocationBottomSheetVisible)
        },
        onReviewValueChanged = { review ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.ReviewTextChanged(review))
        },
        onStarClicked = { star ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.StarClicked(star))
        },
        onRatingChanged = { rating ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.ReviewRatingChanged(rating))
        },
        bottomSheetCompleteButtonClicked = { location ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.SetLocation(location))
        },
        sidoOnclick = { sido ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.SelectSido(sido))
        },
        guOnclick = { gu ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.SelectGu(gu))
        },
        dongOnclick = { dong ->
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.SelectDong(dong))
        },
        writeCompleteButtonClicked = {
            viewModel.setEvent(ReviewWriteContract.ReviewWriteEvent.WriteCompleteButtonClicked)
        },
        popBackStack = {
            viewModel.setSideEffect(ReviewWriteContract.ReviewWriteSideEffect.PopBackStack)
        },
    )
}

@Composable
fun ReviewWriteScreen(
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    uiState: ReviewWriteContract.ReviewWriteUiState = ReviewWriteContract.ReviewWriteUiState(),
    changeLocationBottomSheetVisible: () -> Unit = {},
    categoryChipClicked: (ArabyteJobCategory) -> Unit = {},
    onCompanyValueChanged: (String) -> Unit = {},
    onReviewValueChanged: (String) -> Unit = {},
    onStarClicked: (Int) -> Unit = {},
    onRatingChanged: (NullableReviewRating) -> Unit = {},
    bottomSheetCompleteButtonClicked: (String) -> Unit = {},
    sidoOnclick: (LocationData) -> Unit = {},
    guOnclick: (LocationData) -> Unit = {},
    dongOnclick: (LocationData) -> Unit = {},
    writeCompleteButtonClicked: () -> Unit = {},
    popBackStack: () -> Unit = {},
) {
    val horizontalModifier = Modifier.padding(horizontal = 16.dp)
    val focusManager = LocalFocusManager.current

    Box(
        modifier =
            modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTapGestures(
                        onTap = {
                            focusManager.clearFocus()
                        },
                        onPress = { focusManager.clearFocus() },
                    )
                },
        contentAlignment = Alignment.BottomCenter,
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(color = ArabyteTheme.colors.white)
                    .padding(innerPaddingValues),
        ) {
            ArabyteTopAppBar(
                optionalText = stringResource(R.string.review_write_complete),
                optionalTextColor = ArabyteTheme.colors.mainBlue,
                useBack = true,
                title = stringResource(R.string.review_write_top_bar_title),
                onBackClick = popBackStack,
                onOptionalClick = writeCompleteButtonClicked,
            )
            LazyColumn(
                modifier =
                    Modifier.fillMaxWidth(),
            ) {
                item {
                    ArabyteNormalTextField(
                        modifier = horizontalModifier,
                        title = stringResource(R.string.review_write_company),
                        textMaxLength = 20,
                        text = uiState.companyName,
                        onValueChange = { text ->
                            onCompanyValueChanged(text)
                        },
                        validationState = uiState.companyValidationState,
                        placeholder = stringResource(R.string.review_write_company_placeholder),
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(13.dp))
                }
                item {
                    ArabyteLocationButton(
                        modifier = horizontalModifier,
                        onClicked = changeLocationBottomSheetVisible,
                        location = uiState.region,
                        title = stringResource(R.string.review_write_region),
                        isSelected = uiState.region.isNotEmpty(),
                    )
                }
                item {
                    Spacer(modifier = Modifier.height(26.dp))
                }
                item {
                    Text(
                        text = stringResource(R.string.review_write_job_category),
                        modifier = horizontalModifier,
                        style = ArabyteTheme.typography.bodySemi15,
                        color = ArabyteTheme.colors.black,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(
                        modifier = horizontalModifier,
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                    ) {
                        ArabyteJobCategory.entries.forEach { category ->
                            ArabyteChipButton(
                                buttonText = category.label,
                                enabled = (uiState.jobCategory != null && uiState.jobCategory == category),
                                buttonClicked = {
                                    categoryChipClicked(category)
                                },
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(25.dp))
                    HorizontalDivider(thickness = 8.dp, color = ArabyteTheme.colors.gray01)
                }
                item {
                    Spacer(modifier = Modifier.height(15.dp))

                    ReviewWriteEvaluation(
                        modifier = horizontalModifier,
                        star = uiState.star,
                        starClicked = { clickedStar ->
                            onStarClicked(clickedStar)
                        },
                        onTextChanged = { text ->
                            onReviewValueChanged(text)
                        },
                        reviewText = uiState.reviewText,
                    )
                    Spacer(modifier = Modifier.height(13.dp))
                }

                item {
                    ReviewWritingRating(
                        modifier = horizontalModifier,
                        reviewRating = uiState.reviewRating,
                        onRatingChanged = { newRating ->
                            onRatingChanged(newRating)
                        },
                    )
                    Spacer(modifier = Modifier.height(39.dp))
                }
            }
        }

        if (uiState.locationBottomSheetVisible) {
            Box(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(ArabyteTheme.colors.black.copy(alpha = 0.3f))
                        .noRippleClickable(changeLocationBottomSheetVisible),
            )

            ArabyteLocationBottomSheet(
                modifier = Modifier.padding(bottom = innerPaddingValues.calculateBottomPadding()),
                bottomSheetClose = changeLocationBottomSheetVisible,
                completeButtonClicked = { location ->
                    bottomSheetCompleteButtonClicked(location)
                    changeLocationBottomSheetVisible()
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
private fun ReviewWriteScreenPreview() {
    ArabyteAOSTheme { ReviewWriteScreen() }
}
