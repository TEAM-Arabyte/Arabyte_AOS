package com.konkuk.arabyte_aos.presentation.ui.reviewdetail

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.usecase.reivew.GetReviewDetailUseCase
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
    private val getUserIdUseCase: GetUserIdUseCase
) : BaseViewModel<ReviewDetailContract.ReviewDetailUiState, ReviewDetailContract.ReviewDetailSideEffect, ReviewDetailContract.ReviewDetailEvent>() {
    override fun createInitialState(): ReviewDetailContract.ReviewDetailUiState = ReviewDetailContract.ReviewDetailUiState()

    override suspend fun handleEvent(event: ReviewDetailContract.ReviewDetailEvent) {
        when (event) {
            is ReviewDetailContract.ReviewDetailEvent.GetReviewDetail -> getReviewDetail(reviewId = event.reviewId)

            is ReviewDetailContract.ReviewDetailEvent.GetUserID -> getUserId()

            is ReviewDetailContract.ReviewDetailEvent.ChangeDialogVisible -> {setState { copy(dialogVisible = !currentState.dialogVisible) }}
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
}
