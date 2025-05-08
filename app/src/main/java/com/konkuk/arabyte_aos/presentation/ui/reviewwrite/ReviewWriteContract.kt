package com.konkuk.arabyte_aos.presentation.ui.reviewwrite

import com.konkuk.arabyte_aos.domain.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.domain.model.LocationData
import com.konkuk.arabyte_aos.domain.model.NullableReviewRating
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import com.konkuk.arabyte_aos.presentation.util.view.TextFieldValidationState

class ReviewWriteContract {
    data class ReviewWriteUiState(
        val loadState: LoadState = LoadState.Idle,
        val companyName: String = "",
        val companyId: Int = 1,
        val companyValidationState: TextFieldValidationState = TextFieldValidationState.IDLE,
        val jobCategory: ArabyteJobCategory? = null,
        val region: String = "",
        val locationId: Int = 0,
        val star: Int = 0,
        val reviewText: String = "",
        val reviewRating: NullableReviewRating = NullableReviewRating(),
        val locationBottomSheetVisible: Boolean = false,
        val sidoList: List<LocationData> = emptyList(),
        val guList: List<LocationData> = emptyList(),
        val dongList: List<LocationData> = emptyList(),
        val selectedSido: LocationData? = null,
        val selectedGu: LocationData? = null,
        val selectedDong: LocationData? = null,
    ) : UiState

    sealed interface ReviewWriteSideEffect : UiSideEffect {
        data object NavigateToReviewList : ReviewWriteSideEffect

        data object PopBackStack : ReviewWriteSideEffect

        data object ShowServerErrorToast : ReviewWriteSideEffect

        data object ShowDataValidErrorToast : ReviewWriteSideEffect
    }

    sealed class ReviewWriteEvent : UiEvent {
        data class CompanyTextChanged(val company: String) : ReviewWriteEvent()

        data class JobCategoryClicked(val clickedJobCategory: ArabyteJobCategory) : ReviewWriteEvent()

        data class StarClicked(val star: Int) : ReviewWriteEvent()

        data class ReviewTextChanged(val reviewText: String) : ReviewWriteEvent()

        data object ChangeLocationBottomSheetVisible : ReviewWriteEvent()

        data class ReviewRatingChanged(val reviewRating: NullableReviewRating) : ReviewWriteEvent()

        data class SetLocation(val location: String) : ReviewWriteEvent()

        data object LoadSidoList : ReviewWriteEvent()

        data class LoadGuList(val sidoCode: String) : ReviewWriteEvent()

        data class LoadDongList(val sidoCode: String, val guCode: String) : ReviewWriteEvent()

        data class SelectSido(val sido: LocationData) : ReviewWriteEvent()

        data class SelectGu(val gu: LocationData) : ReviewWriteEvent()

        data class SelectDong(val dong: LocationData) : ReviewWriteEvent()

        data object WriteCompleteButtonClicked : ReviewWriteEvent()
    }
}
