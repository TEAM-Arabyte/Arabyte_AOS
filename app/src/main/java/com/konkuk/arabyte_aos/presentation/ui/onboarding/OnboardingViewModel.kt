package com.konkuk.arabyte_aos.presentation.ui.onboarding

import com.konkuk.arabyte_aos.presentation.type.view.OnboardingType
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel
    @Inject
    constructor() : BaseViewModel<OnboardingContract.OnboardingUiState, OnboardingContract.OnboardingSideEffect, OnboardingContract.OnboardingEvent>() {
        override fun createInitialState(): OnboardingContract.OnboardingUiState = OnboardingContract.OnboardingUiState()

        override suspend fun handleEvent(event: OnboardingContract.OnboardingEvent) {
            when (event) {
                is OnboardingContract.OnboardingEvent.CompleteButtonClicked -> completeButtonClicked()
                is OnboardingContract.OnboardingEvent.ChangeCareerMonthValue -> monthCareerValueChanged(event.month)
                is OnboardingContract.OnboardingEvent.ChangeCareerYearValue -> yearCareerValueChanged(event.year)
                is OnboardingContract.OnboardingEvent.SelectJobCategory -> selectCategory(event.category)
            }
        }

        private fun completeButtonClicked() {
            if (currentState.onboardingType == OnboardingType.FIRST)
                {
                    setState {
                        copy(
                            onboardingType = OnboardingType.SECOND,
                            buttonEnabled = false,
                        )
                    }
                } else
                {
                    setState { copy(loadState = LoadState.Success) }
                }
        }

        private fun yearCareerValueChanged(year: String) {
            if (yearRegex.matches(year))
                {
                    setState {
                        copy(
                            careerYear = year,
                            buttonEnabled = (year.isNotEmpty() && currentState.careerMonth.isNotEmpty()),
                        )
                    }
                }
        }

        private fun monthCareerValueChanged(month: String) {
            if (monthRegex.matches(month))
                {
                    setState {
                        copy(
                            careerMonth = month,
                            buttonEnabled = (month.isNotEmpty() && currentState.careerYear.isNotEmpty()),
                        )
                    }
                }
        }

        private fun selectCategory(category: String) {
            setState {
                val updatedList =
                    if (currentState.selectedCategories.contains(category)) {
                        currentState.selectedCategories - category
                    } else {
                        currentState.selectedCategories + category
                    }
                copy(
                    selectedCategories = updatedList,
                    buttonEnabled = currentState.selectedCategories.isNotEmpty(),
                )
            }
        }

        companion object {
            private const val YEAR_REGEX_PATTERN = "^(\\d|[1-9]\\d)?$"

            private const val MONTH_REGEX_PATTERN = "^(\\d|1[0-2])?$"

            val yearRegex = Regex(YEAR_REGEX_PATTERN)
            val monthRegex = Regex(MONTH_REGEX_PATTERN)
        }
    }
