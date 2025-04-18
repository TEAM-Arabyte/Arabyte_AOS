package com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.model.ReviewHelpfulType
import com.konkuk.arabyte_aos.presentation.model.generateReviewHelpfulList
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteEvaluationButton
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewDetailHelpful(
    likeCounts: Map<ReviewHelpfulType, Int> = emptyMap(),
    selectedType: ReviewHelpfulType? = null,
    onItemClick: (ReviewHelpfulType, Boolean) -> Unit = { _, _ -> },
    modifier: Modifier = Modifier,
) {
    val helpfulList =
        remember {
            generateReviewHelpfulList(
                likeCounts = likeCounts,
                selectedType = selectedType,
                onClick = onItemClick,
            )
        }

    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .background(color = ArabyteTheme.colors.white)
                .padding(horizontal = 16.dp, vertical = 13.dp),
    ) {
        Text(
            text = "이 리뷰가 도움이 되었나요?",
            style = ArabyteTheme.typography.bodyBold15,
            color = ArabyteTheme.colors.black,
        )

        Spacer(modifier = Modifier.height(9.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(9.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            helpfulList.forEach { helpful ->

                ArabyteEvaluationButton(
                    likeCount = helpful.likeCount,
                    iconRes = helpful.iconRes,
                    enabled = helpful.isSelected,
                    buttonClicked = {
                        helpful.onClick(it)
                    },
                )
            }
        }
    }
}
