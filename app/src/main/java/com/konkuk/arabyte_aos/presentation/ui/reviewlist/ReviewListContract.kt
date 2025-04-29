package com.konkuk.arabyte_aos.presentation.ui.reviewlist

import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.model.ReviewItem
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class ReviewListContract {
    data class ReviewListUiState(
        val loadState: LoadState = LoadState.Idle,
        val listSize: Int = 0,
        val certifiedFilterSelected: Boolean = false,
        val selectedRegion: String = "",
        val selectedCategory: String = "",
        val reviewList: List<ReviewItem> = emptyList(),
        val regionBottomSheetVisible: Boolean = false,
        val categoryBottomSheetVisible: Boolean = false,
        val sidoList: List<LocationData> = emptyList(),
        val guList: List<LocationData> = emptyList(),
        val dongList: List<LocationData> = emptyList(),
        val selectedSido: LocationData? = null,
        val selectedGu: LocationData? = null,
        val selectedDong: LocationData? = null,
        val selectedCategories: List<String> = emptyList(),
    ) : UiState

    sealed interface ReviewListSideEffect : UiSideEffect {
        data object DummySideEffect : ReviewListSideEffect
    }

    sealed class ReviewListEvent : UiEvent {
        data object ClickCertifiedFilterButton : ReviewListEvent()

        data object ChangeCategoryBottomSheetVisible : ReviewListEvent()

        data object ChangeRegionBottomSheetVisible : ReviewListEvent()

        data object SetRegionFilter : ReviewListEvent()

        data object ResetRegionFilter : ReviewListEvent()

        data object ResetCategoryFilter : ReviewListEvent()

        data object ResetAllFilter : ReviewListEvent()

        data object LoadSidoList : ReviewListEvent()

        data class LoadGuList(val sidoCode: String) : ReviewListEvent()

        data class LoadDongList(val sidoCode: String, val guCode: String) : ReviewListEvent()

        data class SelectSido(val sido: LocationData) : ReviewListEvent()

        data class SelectGu(val gu: LocationData) : ReviewListEvent()

        data class SelectDong(val dong: LocationData) : ReviewListEvent()

        data class SelectJobCategory(val category: String) : ReviewListEvent()

        data object ClickCategoryBottomSheetCompleteButton : ReviewListEvent()

        data object LoadReviewList : ReviewListEvent()
    }
}
