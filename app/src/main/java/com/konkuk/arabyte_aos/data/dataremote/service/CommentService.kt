package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostCommentRequestDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.COMMENTS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface CommentService {
    @POST("/$COMMENTS/{articleId}")
    suspend fun postComment(
        @Body postCommentRequestDto: PostCommentRequestDto,
    ): Response<Unit>
}
