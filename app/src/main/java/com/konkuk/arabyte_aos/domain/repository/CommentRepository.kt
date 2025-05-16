package com.konkuk.arabyte_aos.domain.repository

import com.konkuk.arabyte_aos.domain.model.PostComment

interface CommentRepository {
    suspend fun postComment(
        postComment: PostComment,
    ): Result<Unit>
}
