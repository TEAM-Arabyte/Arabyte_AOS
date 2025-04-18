package com.konkuk.arabyte_aos.presentation.ui.reviewlist

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.usecase.locations.GetDongUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetGuUseCase
import com.konkuk.arabyte_aos.domain.usecase.locations.GetSidoUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ReviewListViewModel
    @Inject
    constructor(
        private val getSidoUseCase: GetSidoUseCase,
        private val getGuUseCase: GetGuUseCase,
        private val getDongUseCase: GetDongUseCase,
    ) : BaseViewModel<ReviewListContract.ReviewListUiState, ReviewListContract.ReviewListSideEffect, ReviewListContract.ReviewListEvent>() {
        override fun createInitialState(): ReviewListContract.ReviewListUiState = ReviewListContract.ReviewListUiState()

        override suspend fun handleEvent(event: ReviewListContract.ReviewListEvent) {
            when (event) {
                is ReviewListContract.ReviewListEvent.ClickCertifiedFilterButton -> clickCertifiedFilter()

                is ReviewListContract.ReviewListEvent.ChangeCategoryBottomSheetVisible -> {
                    setState { copy(categoryBottomSheetVisible = !currentState.categoryBottomSheetVisible) }
                }

                is ReviewListContract.ReviewListEvent.ChangeRegionBottomSheetVisible -> {
                    setState { copy(regionBottomSheetVisible = !currentState.regionBottomSheetVisible) }
                }

                is ReviewListContract.ReviewListEvent.LoadSidoList -> loadSidoList()

                is ReviewListContract.ReviewListEvent.LoadGuList -> loadGuList(sidoCode = event.sidoCode)

                is ReviewListContract.ReviewListEvent.LoadDongList -> loadDongList(sidoCode = event.sidoCode, guCode = event.guCode)

                is ReviewListContract.ReviewListEvent.SelectSido -> selectSido(event.sido)

                is ReviewListContract.ReviewListEvent.SelectGu -> selectGu(event.gu)

                is ReviewListContract.ReviewListEvent.SelectDong -> selectDong(event.dong)

                is ReviewListContract.ReviewListEvent.SetRegionFilter -> setRegionFilter()

                is ReviewListContract.ReviewListEvent.ResetRegionFilter -> resetRegionFilter()

                is ReviewListContract.ReviewListEvent.ResetAllFilter -> resetAllFilter()

                is ReviewListContract.ReviewListEvent.SelectJobCategory -> selectCategory(event.category)

                is ReviewListContract.ReviewListEvent.ResetCategoryFilter -> resetCategoryFilter()

                is ReviewListContract.ReviewListEvent.ClickCategoryBottomSheetCompleteButton -> clickCategoryBottomSheetCompleteButton()
            }
        }

        private fun clickCertifiedFilter() {
            setState { copy(certifiedFilterSelected = !currentState.certifiedFilterSelected) }
        }

        private fun loadSidoList() {
            viewModelScope.launch {
                getSidoUseCase().onSuccess { sidoList ->
                    setState { copy(sidoList = sidoList) }
                }.onFailure { e ->
                    DebugLog.e("GetSidoUseCase", "Error: ${e.message}", e)
                }
            }
        }

        private fun selectSido(sido: LocationData) {
            loadGuList(sidoCode = sido.sidoCode)
            setState { copy(selectedSido = sido, dongList = emptyList(), selectedGu = null, selectedDong = null) }
        }

        private fun loadGuList(sidoCode: String) {
            viewModelScope.launch {
                getGuUseCase(sidoCode = sidoCode).onSuccess { guList ->
                    setState { copy(guList = guList) }
                }.onFailure { e ->
                    DebugLog.e("GetGuUseCase", "Error: ${e.message}", e)
                }
            }
        }

        private fun selectGu(gu: LocationData) {
            loadDongList(sidoCode = gu.sidoCode, guCode = gu.guCode)
            setState { copy(selectedGu = gu, dongList = emptyList(), selectedDong = null) }
        }

        private fun loadDongList(
            sidoCode: String,
            guCode: String,
        ) {
            viewModelScope.launch {
                getDongUseCase(sidoCode = sidoCode, guCode = guCode).onSuccess { dongList ->
                    setState { copy(dongList = dongList) }
                }.onFailure { e ->
                    DebugLog.e("GetDongUseCase", "Error: ${e.message}", e)
                }
            }
        }

        private fun selectDong(dong: LocationData) {
            setState { copy(selectedDong = dong) }
        }

        private fun setRegionFilter() {
            setState {
                copy(
                    selectedRegion = "${currentState.selectedSido?.sidoName ?: ""} ${currentState.selectedGu?.guName ?: ""} ${currentState.selectedDong?.dongName ?: ""}",
                    regionBottomSheetVisible = false,
                )
            }
        }

        private fun resetRegionFilter() {
            setState {
                copy(
                    selectedRegion = "",
                    selectedSido = null,
                    selectedDong = null,
                    selectedGu = null,
                    regionBottomSheetVisible = false,
                )
            }
        }

        private fun resetAllFilter() {
            resetRegionFilter()
            resetCategoryFilter()
            setState { copy(certifiedFilterSelected = false) }
        }

        private fun selectCategory(category: String) {
            setState {
                val currentList = currentState.selectedCategories

                val updatedList =
                    if (currentList.contains(category)) {
                        currentList - category
                    } else {
                        if (currentList.size < 3) currentList + category else currentList
                    }
                copy(
                    selectedCategories = updatedList,
                )
            }
        }

        private fun resetCategoryFilter() {
            setState {
                copy(
                    selectedCategory = "",
                    selectedCategories = emptyList(),
                    categoryBottomSheetVisible = false,
                )
            }
        }

        private fun clickCategoryBottomSheetCompleteButton() {
            when (currentState.selectedCategories.size) {
                1 -> setState { copy(selectedCategory = currentState.selectedCategories[0], categoryBottomSheetVisible = false) }
                0 -> setState { copy(selectedCategory = "", categoryBottomSheetVisible = false) }
                else -> setState { copy(selectedCategory = "${ currentState.selectedCategories[0]}+외 ${currentState.selectedCategories.size - 1}", categoryBottomSheetVisible = false) }
            }
        }
    }
