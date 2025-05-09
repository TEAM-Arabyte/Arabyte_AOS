package com.konkuk.arabyte_aos.domain.model

import androidx.annotation.DrawableRes
import com.konkuk.arabyte_aos.R

data class ReviewHelpful(
    @DrawableRes val iconRes: Int,
    val likeCount: Int,
    val isSelected: Boolean,
    val onClick: (Boolean) -> Unit,
)

enum class ReviewHelpfulType(
    @DrawableRes val iconRes: Int,
) {
    BAD(R.drawable.ic_review_emotion_bad_20),
    NORMAL(R.drawable.ic_review_emotion_normal_20),
    GOOD(R.drawable.ic_review_emotion_good_20),
}

fun generateReviewHelpfulList(
    likeCounts: Map<ReviewHelpfulType, Int> = emptyMap(),
    selectedType: ReviewHelpfulType? = null,
    onClick: (ReviewHelpfulType, Boolean) -> Unit = { _, _ -> },
): List<ReviewHelpful> {
    return ReviewHelpfulType.entries.map { type ->
        ReviewHelpful(
            iconRes = type.iconRes,
            likeCount = likeCounts[type] ?: 0,
            isSelected = type == selectedType,
            onClick = { isEnabled ->
                onClick(type, isEnabled)
            },
        )
    }
}
