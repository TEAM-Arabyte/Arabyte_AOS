package com.konkuk.arabyte_aos.presentation.ui.noticeboard

import com.konkuk.arabyte_aos.presentation.type.component.ArabyteNoticeBoardCategoryType
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NoticeBoardListViewModel
    @Inject
    constructor() : BaseViewModel<NoticeBoardListContract.NoticeBoardListUiState, NoticeBoardListContract.NoticeBoardListSideEffect, NoticeBoardListContract.NoticeBoardListUiEvent>() {
        override fun createInitialState(): NoticeBoardListContract.NoticeBoardListUiState = NoticeBoardListContract.NoticeBoardListUiState()

        override suspend fun handleEvent(event: NoticeBoardListContract.NoticeBoardListUiEvent) {
            when (event) {
                is NoticeBoardListContract.NoticeBoardListUiEvent.SelectCategory -> selectCategory(event.noticeBoardCategoryType)
                is NoticeBoardListContract.NoticeBoardListUiEvent.LoadNoticeBoardList -> loadNoticeBoardList(event.noticeBoardCategoryType)
            }
        }

        private fun loadNoticeBoardList(noticeBoardCategoryType: ArabyteNoticeBoardCategoryType) {
            // NoticeBoardListUiState 의 noticeBoardList 변경하기 <- usecase에서 filter 된 거 가져오기..?
            setState {
                copy(
                    noticeBoardCount = noticeBoardList.size,
                    noticeBoardList = noticeBoardList,
                )
            }
        }

        private fun selectCategory(noticeBoardCategoryType: ArabyteNoticeBoardCategoryType) {
            // NoticeBoardListUiState 의 selectedCategory 변경하고
            setState { copy(selectedCategory = noticeBoardCategoryType) }
        }
    }
