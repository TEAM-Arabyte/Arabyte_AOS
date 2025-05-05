package com.konkuk.arabyte_aos.presentation.ui.reviewwrite

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.model.PostReview
import com.konkuk.arabyte_aos.domain.model.isNotNull
import com.konkuk.arabyte_aos.domain.model.toReviewRating
import com.konkuk.arabyte_aos.domain.usecase.locations.GetDongUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetGuUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetSidoUseCase
import com.konkuk.arabyte_aos.domain.usecase.reivew.PostReviewUseCase
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewWriteViewModel
    @Inject
    constructor(
        private val getSidoUseCase: GetSidoUseCase,
        private val getGuUseCase: GetGuUseCase,
        private val getDongUseCase: GetDongUseCase,
        private val postReviewUseCase: PostReviewUseCase,
    ) : BaseViewModel<ReviewWriteContract.ReviewWriteUiState, ReviewWriteContract.ReviewWriteSideEffect, ReviewWriteContract.ReviewWriteEvent>() {
        override fun createInitialState(): ReviewWriteContract.ReviewWriteUiState = ReviewWriteContract.ReviewWriteUiState()

        override suspend fun handleEvent(event: ReviewWriteContract.ReviewWriteEvent) {
            when (event) {
                is ReviewWriteContract.ReviewWriteEvent.CompanyTextChanged -> {
                    onCompanyTextChanged(event.company)
                }

                is ReviewWriteContract.ReviewWriteEvent.ChangeLocationBottomSheetVisible -> {
                    setState { copy(locationBottomSheetVisible = !currentState.locationBottomSheetVisible) }
                }

                is ReviewWriteContract.ReviewWriteEvent.JobCategoryClicked -> {
                    selectCategory(event.clickedJobCategory)
                }

                is ReviewWriteContract.ReviewWriteEvent.ReviewTextChanged -> {
                    onReviewTextChanged(event.reviewText)
                }

                is ReviewWriteContract.ReviewWriteEvent.StarClicked -> {
                    setState { copy(star = event.star) }
                }

                is ReviewWriteContract.ReviewWriteEvent.ReviewRatingChanged -> {
                    setState {
                        copy(reviewRating = event.reviewRating)
                    }
                }

                is ReviewWriteContract.ReviewWriteEvent.SetLocation -> {
                    setState { copy(region = event.location) }
                }

                is ReviewWriteContract.ReviewWriteEvent.LoadSidoList -> loadSidoList()

                is ReviewWriteContract.ReviewWriteEvent.LoadGuList -> loadGuList(sidoCode = event.sidoCode)

                is ReviewWriteContract.ReviewWriteEvent.LoadDongList -> loadDongList(sidoCode = event.sidoCode, guCode = event.guCode)

                is ReviewWriteContract.ReviewWriteEvent.SelectSido -> selectSido(event.sido)

                is ReviewWriteContract.ReviewWriteEvent.SelectGu -> selectGu(event.gu)

                is ReviewWriteContract.ReviewWriteEvent.SelectDong -> selectDong(event.dong)

                is ReviewWriteContract.ReviewWriteEvent.WriteCompleteButtonClicked -> completeButtonClicked()
            }
        }

        private fun onCompanyTextChanged(company: String) {
            val trimmed = company.take(20)
            setState {
                copy(
                    companyName = trimmed,
                )
            }
        }

        private fun onReviewTextChanged(review: String) {
            val trimmed = review.take(20)
            setState {
                copy(
                    reviewText = trimmed,
                )
            }
        }

        private fun selectCategory(category: ArabyteJobCategory) {
            setState {
                copy(jobCategory = category)
            }
        }

        private fun loadSidoList() {
            viewModelScope.launch {
                getSidoUseCase().onSuccess { sidoList ->
                    setState { copy(sidoList = sidoList) }
                }.onFailure { e ->
                    Log.e("GetSidoUseCase", "Error: ${e.message}", e)
                }
            }
        }

        private fun selectSido(sido: LocationData) {
            loadGuList(sidoCode = sido.sidoCode)
            setState { copy(selectedSido = sido, dongList = emptyList(), selectedGu = null, selectedDong = null, locationId = sido.id) }
        }

        private fun loadGuList(sidoCode: String) {
            viewModelScope.launch {
                getGuUseCase(sidoCode = sidoCode).onSuccess { guList ->
                    setState { copy(guList = guList) }
                }.onFailure { e ->
                    Log.e("GetGuUseCase", "Error: ${e.message}", e)
                }
            }
        }

        private fun selectGu(gu: LocationData) {
            loadDongList(sidoCode = gu.sidoCode, guCode = gu.guCode)
            setState { copy(selectedGu = gu, dongList = emptyList(), selectedDong = null, locationId = gu.id) }
        }

        private fun loadDongList(
            sidoCode: String,
            guCode: String,
        ) {
            viewModelScope.launch {
                getDongUseCase(sidoCode = sidoCode, guCode = guCode).onSuccess { dongList ->
                    setState { copy(dongList = dongList) }
                }.onFailure { e ->
                    Log.e("GetDongUseCase", "Error: ${e.message}", e)
                }
            }
        }

        private fun selectDong(dong: LocationData) {
            setState { copy(selectedDong = dong, locationId = dong.id) }
        }

        private fun completeButtonClicked() {
            val state = currentState
            val isValid =
                state.jobCategory != null &&
                    state.reviewRating.isNotNull() &&
                    state.reviewText.isNotBlank() &&
                    state.star > 0 && state.locationId > 0 && state.companyId > 0

            if (isValid) {
                postReview()
            } else {
                setSideEffect(ReviewWriteContract.ReviewWriteSideEffect.ShowDataValidErrorToast)
            }
        }

        private fun postReview() {
            viewModelScope.launch {
                val result =
                    postReviewUseCase(
                        postReview =
                            PostReview(
                                companyId = currentState.companyId,
                                locationId = currentState.locationId,
                                category = currentState.jobCategory!!,
                                text = currentState.reviewText,
                                star = currentState.star,
                                reviewRating = currentState.reviewRating.toReviewRating(),
                            ),
                    )
                if (result.isSuccess) {
                    setSideEffect(ReviewWriteContract.ReviewWriteSideEffect.NavigateToReviewList)
                } else {
                    setSideEffect(ReviewWriteContract.ReviewWriteSideEffect.ShowServerErrorToast)
                }
            }
        }
    }
