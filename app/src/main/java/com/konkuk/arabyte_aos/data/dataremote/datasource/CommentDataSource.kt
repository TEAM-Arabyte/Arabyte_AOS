package com.konkuk.arabyte_aos.data.dataremote.datasource

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostCommentRequestDto
import retrofit2.Response

interface CommentDataSource {
    suspend fun postComment(
        articleId: Long,
        postCommentRequestDto: PostCommentRequestDto,
    ): Response<Unit>
}
