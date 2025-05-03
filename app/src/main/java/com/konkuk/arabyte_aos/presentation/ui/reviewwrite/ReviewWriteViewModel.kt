package com.konkuk.arabyte_aos.presentation.ui.reviewwrite

import com.konkuk.arabyte_aos.domain.usecase.locations.GetDongUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetGuUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetSidoUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReviewWriteViewModel
    @Inject
    constructor(
        private val getSidoUseCase: GetSidoUseCase,
        private val getGuUseCase: GetGuUseCase,
        private val getDongUseCase: GetDongUseCase,
    ) : BaseViewModel<ReviewWriteContract.ReviewWriteUiState, ReviewWriteContract.ReviewWriteSideEffect, ReviewWriteContract.ReviewWriteEvent>() {
        override fun createInitialState(): ReviewWriteContract.ReviewWriteUiState = ReviewWriteContract.ReviewWriteUiState()

        override suspend fun handleEvent(event: ReviewWriteContract.ReviewWriteEvent) {
            when (event) {
                ReviewWriteContract.ReviewWriteEvent.ClickCertifiedFilterButton -> TODO()
            }
        }
    }
