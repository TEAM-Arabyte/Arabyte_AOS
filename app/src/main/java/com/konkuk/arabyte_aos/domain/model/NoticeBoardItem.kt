package com.konkuk.arabyte_aos.domain.model

import com.konkuk.arabyte_aos.presentation.type.component.ArabyteBoardCategoryType

data class NoticeBoardItem(
    val title: String,
    val text: String,
    val likeCount: Int,
    val commentCount: Int,
    val uploadAt: String,
    val thumbnailImage: String,
    val articleCategoryType: ArabyteBoardCategoryType,
    val isLiked: Boolean,
)
