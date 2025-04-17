package com.konkuk.arabyte_aos.presentation.ui.reviewlist

import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReviewListViewModel
    @Inject
    constructor() : BaseViewModel<ReviewListContract.ReviewListUiState, ReviewListContract.ReviewListSideEffect, ReviewListContract.ReviewListEvent>() {
        override fun createInitialState(): ReviewListContract.ReviewListUiState = ReviewListContract.ReviewListUiState()

        override suspend fun handleEvent(event: ReviewListContract.ReviewListEvent) {
            when (event) {
                else -> {}
            }
        }
    }
