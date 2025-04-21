package com.konkuk.arabyte_aos.presentation.ui.reviewdetail

import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReviewDetailViewModel
    @Inject
    constructor() : BaseViewModel<ReviewDetailContract.ReviewDetailUiState, ReviewDetailContract.ReviewDetailSideEffect, ReviewDetailContract.ReviewDetailEvent>() {
        override fun createInitialState(): ReviewDetailContract.ReviewDetailUiState = ReviewDetailContract.ReviewDetailUiState()

        override suspend fun handleEvent(event: ReviewDetailContract.ReviewDetailEvent) {
            when (event) {
                is ReviewDetailContract.ReviewDetailEvent.DummyEvent -> {}
            }
        }
    }
