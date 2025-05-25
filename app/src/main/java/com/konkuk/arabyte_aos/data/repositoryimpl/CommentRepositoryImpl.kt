package com.konkuk.arabyte_aos.data.repositoryimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.CommentDataSource
import com.konkuk.arabyte_aos.data.mapper.todata.toRequestDto
import com.konkuk.arabyte_aos.domain.model.PostComment
import com.konkuk.arabyte_aos.domain.repository.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl
    @Inject
    constructor(
        private val commentDataSource: CommentDataSource,
    ) : CommentRepository {
        override suspend fun postComment(postComment: PostComment): Result<Unit> =
            runCatching {
                commentDataSource.postComment(
                    articleId = postComment.articleId,
                    postCommentRequestDto = postComment.toRequestDto(),
                )
            }
    }
