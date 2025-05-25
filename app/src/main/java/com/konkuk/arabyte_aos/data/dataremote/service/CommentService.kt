package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostCommentRequestDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.COMMENTS
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CommentService {
    @POST("/$COMMENTS/{articleId}")
    suspend fun postComment(
        @Path("articleId") articleId: Long,
        @Body postCommentRequestDto: PostCommentRequestDto,
    ): Response<Unit>
}
