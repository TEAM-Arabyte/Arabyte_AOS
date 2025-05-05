package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import androidx.lifecycle.viewModelScope
import com.konkuk.arabyte_aos.domain.usecase.comment.PostCommentUseCase
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
        private val postCommentUseCase: PostCommentUseCase,
    ) : BaseViewModel<NoticeBoardDetailContract.NoticeBoardDetailUiState, NoticeBoardDetailContract.NoticeBoardDetailSideEffect, NoticeBoardDetailContract.NoticeBoardDetailEvent>() {
        override fun createInitialState(): NoticeBoardDetailContract.NoticeBoardDetailUiState = NoticeBoardDetailContract.NoticeBoardDetailUiState()

        override suspend fun handleEvent(event: NoticeBoardDetailContract.NoticeBoardDetailEvent) {
            when (event) {
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.GetNoticeBoardDetail -> getNoticeBoardDetail(event.articleId)
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.ChangeAnonymous -> updateAnonymous(event.isAnonymous)
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.ChangeCommentText -> updateCommentText(event.text)
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.SetReplyTarget -> updateReplyTarget(event.parentId)
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.SubmitComment -> postComment(event.articleId)
            }
        }

        private fun updateAnonymous(isAnonymous: Boolean) {
            setState { copy(postComment = postComment.copy(isAnonymous = isAnonymous)) }
        }

        private fun updateCommentText(text: String) {
            setState { copy(postComment = postComment.copy(text = text)) }
        }

        private fun updateReplyTarget(parentId: Long) {
            setState { copy(postComment = postComment.copy(parentId = parentId)) }
        }

        private fun postComment(articleId: Long) {
            viewModelScope.launch {
                val comment = currentState.postComment
                postCommentUseCase(comment)
                    .onSuccess {
                        setEvent(NoticeBoardDetailContract.NoticeBoardDetailEvent.GetNoticeBoardDetail(articleId))
                        updateCommentText("")
                    }
                    .onFailure { e ->
                        DebugLog.d("postComment", e.message)
                    }
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
                                postComment = postComment.copy(articleId = articleId),
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
