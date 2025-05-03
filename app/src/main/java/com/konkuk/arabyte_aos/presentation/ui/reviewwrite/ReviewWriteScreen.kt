package com.konkuk.arabyte_aos.presentation.ui.reviewwrite

import androidx.compose.foundation.background
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.flowlayout.FlowRow
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteChipButton
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLocationButton
import com.konkuk.arabyte_aos.presentation.ui.component.textfield.ArabyteNormalTextField
import com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component.ReviewWriteEvaluation
import com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component.ReviewWritingRating
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewWriteRoute(
    modifier: Modifier = Modifier,
    viewModel: ReviewWriteViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    ReviewWriteScreen(
        modifier = modifier,
        uiState = uiState,
        innerPaddingValues = innerPaddingValues,
    )
}

@Composable
fun ReviewWriteScreen(
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    uiState: ReviewWriteContract.ReviewWriteUiState = ReviewWriteContract.ReviewWriteUiState(),
    changeBottomSheetVisible: () -> Unit = {},
    categoryChipClicked: (ArabyteJobCategory) -> Unit = {},
) {
    val horizontalModifier = Modifier.padding(horizontal = 16.dp)
    Column(
        modifier =
        modifier
            .fillMaxSize()
            .background(color = ArabyteTheme.colors.white)
            .padding(innerPaddingValues),
    ) {
        ArabyteTopAppBar(
            optionalText =  stringResource(R.string.review_write_complete),
            optionalTextColor = ArabyteTheme.colors.mainBlue,
            useBack = true,
            title = stringResource(R.string.review_write_top_bar_title),
            onBackClick = {},
            onOptionalClick = {},
        )
        LazyColumn(
            modifier =
            Modifier.fillMaxWidth(),
        ) {
            item {
                ArabyteNormalTextField(
                    modifier = horizontalModifier,
                    title = stringResource(R.string.review_write_company),
                    textMaxLength = 10,
                    text = uiState.companyName,
                    onValueChange = { text ->
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
                    onClicked = changeBottomSheetVisible,
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
                    color = ArabyteTheme.colors.black
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
                            enabled = uiState.jobCategoryList.contains(category),
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
                    starClicked = {},
                    onTextChanged = {},
                    reviewText = uiState.reviewText,
                )
                Spacer(modifier = Modifier.height(13.dp))
            }

            item {
                ReviewWritingRating(
                    modifier = horizontalModifier,
                    reviewRating = uiState.reviewRating,
                    onRatingChanged = {},
                )
                Spacer(modifier = Modifier.height(39.dp))
            }
        }
    }
}

@Preview
@Composable
private fun ReviewWriteScreenPreview() {
    ArabyteAOSTheme { ReviewWriteScreen() }
}
