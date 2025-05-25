package com.konkuk.arabyte_aos.domain.usecase.comment

import com.konkuk.arabyte_aos.domain.model.PostComment
import com.konkuk.arabyte_aos.domain.repository.CommentRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostCommentUseCase
    @Inject
    constructor(
        private val commentRepository: CommentRepository,
    ) {
        suspend operator fun invoke(
            postComment: PostComment,
        ): Result<Unit> {
            return commentRepository.postComment(
                postComment = postComment,
            )
        }
    }
