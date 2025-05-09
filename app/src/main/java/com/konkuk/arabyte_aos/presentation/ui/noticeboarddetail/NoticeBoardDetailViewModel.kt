package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail

import android.R.attr.text
import androidx.lifecycle.viewModelScope
import buildCommentTree
import com.konkuk.arabyte_aos.domain.usecase.comment.PostCommentUseCase
import com.konkuk.arabyte_aos.domain.usecase.noticeboard.GetNoticeBoardDetailUseCase
import com.konkuk.arabyte_aos.presentation.util.base.BaseViewModel
import com.konkuk.arabyte_aos.presentation.util.log.DebugLog
import com.konkuk.arabyte_aos.presentation.util.view.LoadState
import dagger.hilt.android.lifecycle.HiltViewModel
import flattenCommentTree
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
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.ChangeAnonymous -> setState { copy(postComment = postComment.copy(isAnonymous = event.isAnonymous)) }
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.ChangeCommentText -> setState { copy(postComment = postComment.copy(text = event.text)) }
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.SetReplyTarget -> setState { copy(postComment = postComment.copy(parentId = event.parentId)) }
                is NoticeBoardDetailContract.NoticeBoardDetailEvent.SubmitComment -> postComment(event.articleId)
            }
        }

        private fun postComment(articleId: Long) {
            viewModelScope.launch {
                val comment = currentState.postComment
                postCommentUseCase(comment)
                    .onSuccess {
                        setEvent(NoticeBoardDetailContract.NoticeBoardDetailEvent.GetNoticeBoardDetail(articleId))
                        setState { copy(postComment = postComment.copy(text = "")) }
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
                        val commentTree = buildCommentTree(noticeBoardDetail.comments)
                        val flattenCommentTree = flattenCommentTree(commentTree)
                        setState {
                            copy(
                                loadState = LoadState.Success,
                                noticeBoardDetail = noticeBoardDetail,
                                postComment = postComment.copy(articleId = articleId),
                                commentTree = commentTree,
                                flattenCommentTree = flattenCommentTree,
                            )
                        }
                    }
                    .onFailure { throwable ->
                        DebugLog.e("NoticeBoardDetail", "❌ onFailure: ${throwable.message}")
                    }
            }
        }
    }
