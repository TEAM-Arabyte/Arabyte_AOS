package com.konkuk.arabyte_aos.presentation.ui.reviewdetail

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.model.ReportData
import com.konkuk.arabyte_aos.domain.model.ReportType
import com.konkuk.arabyte_aos.domain.model.ReviewHelpfulType
import com.konkuk.arabyte_aos.domain.usecase.reivew.DeleteReviewDetailUseCase
import com.konkuk.arabyte_aos.domain.usecase.reivew.GetReviewDetailUseCase
import com.konkuk.arabyte_aos.domain.usecase.reivew.PostReviewHelpfulUseCase
import com.konkuk.arabyte_aos.domain.usecase.report.PostReportUseCase
import com.konkuk.arabyte_aos.domain.usecase.user.GetUserIdUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewDetailViewModel
    @Inject
    constructor(
        private val getReviewDetailUseCase: GetReviewDetailUseCase,
        private val getUserIdUseCase: GetUserIdUseCase,
        private val deleteReviewDetailUseCase: DeleteReviewDetailUseCase,
        private val postReviewHelpfulUseCase: PostReviewHelpfulUseCase,
        private val postReportUseCase: PostReportUseCase,
    ) : BaseViewModel<ReviewDetailContract.ReviewDetailUiState, ReviewDetailContract.ReviewDetailSideEffect, ReviewDetailContract.ReviewDetailEvent>() {
        override fun createInitialState(): ReviewDetailContract.ReviewDetailUiState = ReviewDetailContract.ReviewDetailUiState()

        override suspend fun handleEvent(event: ReviewDetailContract.ReviewDetailEvent) {
            when (event) {
                is ReviewDetailContract.ReviewDetailEvent.GetReviewDetail -> getReviewDetail(reviewId = event.reviewId)

                is ReviewDetailContract.ReviewDetailEvent.GetUserID -> getUserId()

                is ReviewDetailContract.ReviewDetailEvent.ChangeDialogVisible -> {
                    setState { copy(dialogVisible = !currentState.dialogVisible) }
                }

                is ReviewDetailContract.ReviewDetailEvent.DialogCompleteButtonClicked -> dialogCompleteButtonClicked(event.isMyReview)

                is ReviewDetailContract.ReviewDetailEvent.ReviewHelpfulClicked -> helpfulClicked(event.isMyReview, event.reviewHelpful)
            }
        }

        private fun getReviewDetail(reviewId: Int) {
            viewModelScope.launch {
                getReviewDetailUseCase(reviewId = reviewId).onSuccess { result ->
                    setState { copy(reviewDetail = result) }
                }.onFailure { e ->
                    DebugLog.e("ReviewDetailViewModel", "Error message: ${e.message}")
                }
            }
        }

        private fun getUserId() {
            viewModelScope.launch {
                setState { copy(currentUserId = getUserIdUseCase()) }
            }
        }

        private fun dialogCompleteButtonClicked(isMyReview: Boolean) {
            if (isMyReview) {
                deleteReviewDetail()
            } else {
                reportReviewDetail()
            }
        }

        private fun deleteReviewDetail() {
            viewModelScope.launch {
                deleteReviewDetailUseCase(reviewId = currentState.reviewDetail.reviewId).onSuccess {
                    setSideEffect(ReviewDetailContract.ReviewDetailSideEffect.NavigateToReviewList)
                }.onFailure {
                    setSideEffect(ReviewDetailContract.ReviewDetailSideEffect.ShowServerErrorToast)
                    setSideEffect(ReviewDetailContract.ReviewDetailSideEffect.NavigateToReviewList)
                }
            }
        }

        private fun reportReviewDetail() {
            viewModelScope.launch {
                postReportUseCase(
                    reportData =
                        ReportData(
                            reportType = ReportType.REVIEW,
                            targetId = currentState.reviewDetail.reviewId.toLong(),
                            reason = "몰라 이자식아",
                        ),
                ).onSuccess {
                    setSideEffect(ReviewDetailContract.ReviewDetailSideEffect.ShowReportToast)
                }.onFailure {
                    setSideEffect(ReviewDetailContract.ReviewDetailSideEffect.ShowServerErrorToast)
                }
            }
        }

        private fun helpfulClicked(
            isMyReview: Boolean,
            helpful: ReviewHelpfulType,
        ) {
            if (isMyReview) {
                setSideEffect(ReviewDetailContract.ReviewDetailSideEffect.ShowAlertToast)
            } else {
                viewModelScope.launch {
                    postReviewHelpfulUseCase(reviewId = currentState.reviewDetail.reviewId, helpful = helpful)
                        .onSuccess { response ->
                            setState { copy(reviewDetail = response) }
                        }
                }
            }
        }
    }
