package com.konkuk.arabyte_aos.data.dataremote.datasourceimpl

import com.konkuk.arabyte_aos.data.dataremote.datasource.CommentDataSource
import com.konkuk.arabyte_aos.data.dataremote.model.request.PostCommentRequestDto
import com.konkuk.arabyte_aos.data.dataremote.service.CommentService
import retrofit2.Response
import javax.inject.Inject

class CommentDataSourceImpl
    @Inject
    constructor(
        private val service: CommentService,
    ) : CommentDataSource {
        override suspend fun postComment(postCommentRequestDto: PostCommentRequestDto): Response<Unit> =
            service.postComment(
                postCommentRequestDto = postCommentRequestDto,
            )
    }
