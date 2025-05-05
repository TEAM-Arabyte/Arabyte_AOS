package com.konkuk.arabyte_aos.presentation.ui.reviewdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.Overtime
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.model.ReviewRating
import com.konkuk.arabyte_aos.domain.model.Salary
import com.konkuk.arabyte_aos.domain.model.SalaryDate
import com.konkuk.arabyte_aos.domain.model.WorkAtmosphere
import com.konkuk.arabyte_aos.domain.model.WorkDifficulty
import com.konkuk.arabyte_aos.domain.model.WorkIntensity
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.model.ReviewHelpfulType
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.presentation.ui.component.bottomsheet.ArabyteLocationBottomSheet
import com.konkuk.arabyte_aos.presentation.ui.dialog.ArabyteTwoButtonDialog
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component.ReviewDetailContent
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component.ReviewDetailHeader
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component.ReviewDetailHelpful
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component.ReviewDetailRating
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewDetailRoute(
    reviewId: Int,
    popBackStack: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: ReviewDetailViewModel = hiltViewModel(),
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(Unit) {
        viewModel.setEvent(ReviewDetailContract.ReviewDetailEvent.GetReviewDetail(reviewId = reviewId))
        viewModel.setEvent(ReviewDetailContract.ReviewDetailEvent.GetUserID)
    }

    LaunchedEffect(viewModel.sideEffect, lifecycleOwner) {
        viewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is ReviewDetailContract.ReviewDetailSideEffect.PopBackStack -> popBackStack()
                }
            }
    }

    ReviewDetailScreen(
        modifier = modifier,
        uiState = uiState,
        innerPaddingValues = innerPaddingValues,
        popBackStack = {
            viewModel.setSideEffect(ReviewDetailContract.ReviewDetailSideEffect.PopBackStack)
        },
        changeDialogVisible = {
            viewModel.setEvent(ReviewDetailContract.ReviewDetailEvent.ChangeDialogVisible)
        }
    )
}

@Composable
fun ReviewDetailScreen(
    popBackStack: () -> Unit,
    changeDialogVisible:()->Unit,
    modifier: Modifier = Modifier,
    uiState: ReviewDetailContract.ReviewDetailUiState=ReviewDetailContract.ReviewDetailUiState(),
    isMyReview:Boolean = uiState.currentUserId==uiState.reviewDetail.userId,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.white)
                .padding(innerPaddingValues),
        ) {
            ArabyteTopAppBar(
                useBack = true,
                onBackClick = popBackStack,
                optionalIconRes = R.drawable.ic_all_optional_button_45,
                onOptionalClick = changeDialogVisible,
            )
            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                item {
                    ReviewDetailHeader(
                        companyName = uiState.reviewDetail.companyName,
                        isCertified = uiState.reviewDetail.isCertified,
                        star = uiState.reviewDetail.star,
                        region = uiState.reviewDetail.region,
                        category =uiState. reviewDetail.category,
                    )
                }
                item {
                    HorizontalDivider(thickness = 5.dp, color = ArabyteTheme.colors.gray01)
                }
                item {
                    ReviewDetailRating(
                        reviewRating = uiState.reviewDetail.reviewRating,
                    )
                }
                item {
                    ReviewDetailContent(
                        content = uiState.reviewDetail.reviewContent,
                    )
                }
                item {
                    ReviewDetailHelpful(
                        likeCounts =
                        mapOf(
                            ReviewHelpfulType.BAD to uiState.reviewDetail.badCount,
                            ReviewHelpfulType.NORMAL to uiState.reviewDetail.normalCount,
                            ReviewHelpfulType.GOOD to uiState.reviewDetail.goodCount,
                        ),
                    )
                }
            }
        }

        if (uiState.dialogVisible) {
            Box(
                modifier =
                Modifier
                    .fillMaxSize()
                    .background(ArabyteTheme.colors.black.copy(alpha = 0.3f))
                    .noRippleClickable (changeDialogVisible),
                contentAlignment = Alignment.Center
            ) {
                ArabyteTwoButtonDialog(
                    modifier = Modifier.padding(horizontal = 30.dp),
                    title = if (isMyReview) stringResource(R.string.review_detail_dialog_delete) else stringResource(R.string.review_detail_dialog_report),
                    completeButtonText =  if (isMyReview) stringResource(R.string.review_detail_button_delete) else stringResource(R.string.review_detail_button_report),
                    cancelButtonClicked = changeDialogVisible,
                    completeButtonClicked = {
                        changeDialogVisible()

                    },
                )
            }
        }
    }
}

@Preview
@Composable
private fun ReviewDetailScreenPreview() {
    ArabyteAOSTheme {
        ReviewDetailScreen(
            popBackStack = { },
            changeDialogVisible = {},
        )
    }
}
