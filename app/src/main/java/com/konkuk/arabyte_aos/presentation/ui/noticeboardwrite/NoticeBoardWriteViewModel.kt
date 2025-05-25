package com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.model.PostNoticeBoardWrite
import com.konkuk.arabyte_aos.domain.usecase.noticeboard.PostNoticeBoardWriteUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeBoardWriteViewModel
    @Inject
    constructor(
        private val postNoticeBoardWriteUseCase: PostNoticeBoardWriteUseCase,
    ) : BaseViewModel<NoticeBoardWriteContract.NoticeBoardWriteUiState, NoticeBoardWriteContract.NoticeBoardWriteSideEffect, NoticeBoardWriteContract.NoticeBoardWriteEvent>() {
        override fun createInitialState(): NoticeBoardWriteContract.NoticeBoardWriteUiState = NoticeBoardWriteContract.NoticeBoardWriteUiState()

        override suspend fun handleEvent(event: NoticeBoardWriteContract.NoticeBoardWriteEvent) {
            when (event) {
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.AnonymousClick -> setState { copy(selectIsAnonymous = event.clickAnonymous) }
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.ContentTextChanged -> onContentTextChanged(event.content)
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.WriteCompleteButtonClicked -> completeButtonClicked()
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.TitleTextChanged -> onTitleTextChanged(event.title)
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.CategoryClick -> setState { copy(selectCategory = event.clickedCategory) }
            }
        }

        private fun onTitleTextChanged(title: String) {
            val trimmed = title.take(10)
            setState { copy(titleText = trimmed) }
        }

        private fun onContentTextChanged(content: String) {
            val trimmed = content.take(300)
            setState { copy(contentText = trimmed) }
        }

        private fun completeButtonClicked() {
            val state = currentState
            val isValid = state.titleText.isNotEmpty() && state.contentText.isNotEmpty() && state.selectCategory != null
            if (isValid) {
                postNoticeBoardWrite()
            } else {
                setSideEffect(NoticeBoardWriteContract.NoticeBoardWriteSideEffect.ShowDataValidErrorToast)
            }
        }

        private fun postNoticeBoardWrite() {
            viewModelScope.launch {
                val result =
                    postNoticeBoardWriteUseCase(
                        postNoticeBoardWrite =
                            PostNoticeBoardWrite(
                                title = currentState.titleText,
                                text = currentState.contentText,
                                likeCount = 0,
                                isAnonymous = currentState.selectIsAnonymous,
                                articleKind = currentState.selectCategory?.name.toString(),
                                articleImages = emptyList(),
                                anonymous = currentState.selectIsAnonymous,
                            ),
                    )
                if (result.isSuccess) {
                    setSideEffect(NoticeBoardWriteContract.NoticeBoardWriteSideEffect.NavigateToNoticeBoardList)
                } else {
                    setSideEffect(NoticeBoardWriteContract.NoticeBoardWriteSideEffect.ShowServerErrorToast)
                }
            }
        }
    }
