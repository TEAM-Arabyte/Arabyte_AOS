package com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite

import android.net.Uri
import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.model.PostNoticeBoardWrite
import com.konkuk.arabyte_aos.domain.usecase.firebase.FirebaseImageUseCase
import com.konkuk.arabyte_aos.domain.usecase.noticeboard.PostNoticeBoardWriteUseCase
import com.konkuk.arabyte_aos.presentation.ui.noticeboardwrite.NoticeBoardWriteContract.NoticeBoardWriteSideEffect
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoticeBoardWriteViewModel
    @Inject
    constructor(
        private val postNoticeBoardWriteUseCase: PostNoticeBoardWriteUseCase,
        private val firebaseImageUseCase: FirebaseImageUseCase,
    ) : BaseViewModel<NoticeBoardWriteContract.NoticeBoardWriteUiState, NoticeBoardWriteContract.NoticeBoardWriteSideEffect, NoticeBoardWriteContract.NoticeBoardWriteEvent>() {
        override fun createInitialState(): NoticeBoardWriteContract.NoticeBoardWriteUiState = NoticeBoardWriteContract.NoticeBoardWriteUiState()

        override suspend fun handleEvent(event: NoticeBoardWriteContract.NoticeBoardWriteEvent) {
            when (event) {
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.AnonymousClick -> setState { copy(selectIsAnonymous = event.clickAnonymous) }
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.ContentTextChanged -> onContentTextChanged(event.content)
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.WriteCompleteButtonClicked -> completeButtonClicked()
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.TitleTextChanged -> onTitleTextChanged(event.title)
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.CategoryClick -> setState { copy(selectCategory = event.clickedCategory) }
                is NoticeBoardWriteContract.NoticeBoardWriteEvent.PhotoSelected -> {
                    setState { copy(previewImageUri = event.uri) }
                    uploadImage(event.uri)
                }
            }
        }

        private fun uploadImage(uri: Uri) {
            viewModelScope.launch {
                val result = firebaseImageUseCase(uri)
                if (result.isSuccess) {
                    val url = result.getOrNull() ?: return@launch
                    DebugLog.d("FirebaseImage", "ViewModel 수신 URL: $url")
                    setState {
                        copy(uploadedImageUrls = uploadedImageUrls + url)
                    }
                } else {
                    setSideEffect(NoticeBoardWriteSideEffect.ShowServerErrorToast)
                }
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
