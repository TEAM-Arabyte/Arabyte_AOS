package com.konkuk.arabyte_aos.presentation.ui.onboarding

import com.konkuk.arabyte_aos.presentation.type.view.OnboardingType
import com.konkuk.arabyte_aos.presentation.util.base.UiEvent
import com.konkuk.arabyte_aos.presentation.util.base.UiSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.UiState
import com.konkuk.arabyte_aos.presentation.util.view.LoadState

class OnboardingContract {
    data class OnboardingUiState(
        val loadState: LoadState = LoadState.Idle,
        val onboardingType: OnboardingType = OnboardingType.FIRST,
        val buttonEnabled: Boolean = false,
        val careerYear: String = "",
        val careerMonth: String = "",
        val selectedCategories: List<String> = emptyList(),
    ) : UiState

    sealed interface OnboardingSideEffect : UiSideEffect {
        data object DummySideEffect : OnboardingSideEffect
    }

    sealed class OnboardingEvent : UiEvent {
        data object CompleteButtonClicked : OnboardingEvent()

        data class ChangeCareerYearValue(val year: String) : OnboardingEvent()

        data class ChangeCareerMonthValue(val month: String) : OnboardingEvent()

        data class SelectJobCategory(val category: String) : OnboardingEvent()
    }
}
