package com.konkuk.arabyte_aos.presentation.ui.noticeboard

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.model.NoticeBoardList
import com.konkuk.arabyte_aos.domain.usecase.noticeboard.GetNoticeBoardListUseCase
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteNoticeBoardCategoryType
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeBoardListViewModel
    @Inject
    constructor(
        private val getNoticeBoardListUseCase: GetNoticeBoardListUseCase,
    ) : BaseViewModel<NoticeBoardListContract.NoticeBoardListUiState, NoticeBoardListContract.NoticeBoardListSideEffect, NoticeBoardListContract.NoticeBoardListUiEvent>() {
        override fun createInitialState(): NoticeBoardListContract.NoticeBoardListUiState = NoticeBoardListContract.NoticeBoardListUiState()

        override suspend fun handleEvent(event: NoticeBoardListContract.NoticeBoardListUiEvent) {
            when (event) {
                is NoticeBoardListContract.NoticeBoardListUiEvent.SelectCategory -> {
                    setState { copy(selectedCategory = event.noticeBoardCategoryType) }
                }
                is NoticeBoardListContract.NoticeBoardListUiEvent.GetNoticeBoardList -> getNoticeBoardList(event.noticeBoardCategoryType)
            }
        }

        private fun getNoticeBoardList(noticeBoardCategoryType: ArabyteNoticeBoardCategoryType) {
            setState { copy(loadState = LoadState.Loading) }
            viewModelScope.launch {
                val result: Result<NoticeBoardList> =
                    getNoticeBoardListUseCase(
                        articleKind = noticeBoardCategoryType.toApiValue(),
                        page = 0,
                        size = 20,
                        sort = "createdAt,desc",
                    )
                result.onSuccess { articleList ->
                    setState {
                        copy(
                            loadState = LoadState.Success,
                            noticeBoardCount = articleList.content.size,
                            noticeBoardList = articleList.content,
                        )
                    }
                }
                    .onFailure { throwable ->
                        DebugLog.e("NoticeBoardList", "❌ onFailure: ${throwable.message}")
                        setState { copy(loadState = LoadState.Error) }
                    }
            }
        }
    }
