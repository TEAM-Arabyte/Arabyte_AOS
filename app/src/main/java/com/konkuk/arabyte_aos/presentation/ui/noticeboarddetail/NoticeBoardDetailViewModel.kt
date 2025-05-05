package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.usecase.noticeboard.GetNoticeBoardDetailUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeBoardDetailViewModel
    @Inject
    constructor(
        private val getNoticeBoardDetailUseCase: GetNoticeBoardDetailUseCase,
    ) : BaseViewModel<NoticeBoardDetailContract.NoticeBoardDetailUiState, NoticeBoardDetailContract.NoticeBoardDetailSideEffect, NoticeBoardDetailContract.NoticeBoardDetailEvent>() {
        override fun createInitialState(): NoticeBoardDetailContract.NoticeBoardDetailUiState = NoticeBoardDetailContract.NoticeBoardDetailUiState()

        override suspend fun handleEvent(event: NoticeBoardDetailContract.NoticeBoardDetailEvent) {
            when (event) {
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.GetNoticeBoardDetail -> getNoticeBoardDetail(event.articleId)
            }
        }

        private fun getNoticeBoardDetail(articleId: Long) {
            viewModelScope.launch {
                getNoticeBoardDetailUseCase(articleId)
                    .onSuccess { noticeBoardDetail ->
                        setState {
                            copy(
                                loadState = LoadState.Success,
                                noticeBoardDetail = noticeBoardDetail,
                            )
                        }
                    }
                    .onFailure { throwable ->
                        DebugLog.e("NoticeBoardDetail", "❌ onFailure: ${throwable.message}")
                        setState { copy(loadState = LoadState.Error) }
                    }
            }
        }
    }
