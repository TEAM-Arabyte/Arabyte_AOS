package com.konkuk.arabyte_aos.data.dataremote.service

import com.konkuk.arabyte_aos.data.dataremote.model.request.PostNoticeBoardLikeRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostNoticeBoardWriteRequestDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardDetailResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.GetNoticeBoardListResponseDto
import com.konkuk.arabyte_aos.data.dataremote.model.response.PostNoticeBoardLikeResponseDto
import com.konkuk.arabyte_aos.data.util.ApiConstraints.ARTICLES
import com.konkuk.arabyte_aos.data.util.ApiConstraints.LIKE
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface NoticeBoardService {
    @GET("/$ARTICLES")
    suspend fun getNoticeBoardList(
        @Query("articleKind") articleKind: String?,
        @Query("page") page: Int,
        @Query("size") size: Int,
        @Query("sort") sort: String = "createdAt,desc",
    ): Response<GetNoticeBoardListResponseDto>

    @GET("/$ARTICLES/{articleId}")
    suspend fun getNoticeBoardDetail(
        @Path("articleId") articleId: Long,
    ): Response<GetNoticeBoardDetailResponseDto>

    @POST("/$ARTICLES")
    suspend fun postNoticeBoardWrite(
        @Body postNoticeBoardWriteRequestDto: PostNoticeBoardWriteRequestDto,
    ): Response<Unit>

    @POST("/$ARTICLES/$LIKE")
    suspend fun postNoticeBoardLike(
        @Body postNoticeBoardLikeRequestDto: PostNoticeBoardLikeRequestDto,
    ): Response<PostNoticeBoardLikeResponseDto>
}
