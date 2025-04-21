package com.konkuk.arabyte_aos.presentation.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.ReviewItem
import com.konkuk.arabyte_aos.presentation.ui.component.chip.ArabyteLocationChip
import com.konkuk.arabyte_aos.presentation.ui.reviewlist.component.ReviewCategoryChip
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

/**
 * 리뷰 항목을 나타내는 컴포넌트입니다. (리뷰 리스트의 item)
 *
 * @param modifier UI 수정 사항을 추가할 수 있는 Modifier입니다.
 * @param companyName 리뷰의 대상이 되는 근로지의 이름입니다.
 * @param isCertified 근로 계약서 인증된 리뷰인 경우, true로 설정합니다. 기본값은 false입니다.
 * @param starRate 리뷰의 별점입니다. Double 타입입니다.
 * @param reviewContent 리뷰의 내용을 나타내는 문자열입니다.
 * @param location 리뷰가 작성된 근로지의 위치입니다.
 * @param category 리뷰(알바)의 카테고리를 나타내는 문자열 리소스 ID로 사용됩니다.
 */

@Composable
fun ArabyteReviewItem(
    reviewItem: ReviewItem,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = ArabyteTheme.colors.gray01,
                    shape = RoundedCornerShape(9.dp),
                )
                .roundedBackgroundWithPadding(
                    backgroundColor = ArabyteTheme.colors.white,
                    cornerRadius = 9.dp,
                    padding = PaddingValues(all = 11.dp),
                ),
        verticalArrangement = Arrangement.spacedBy(7.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = reviewItem.companyName,
                style = ArabyteTheme.typography.bodyBold13,
                color = ArabyteTheme.colors.black,
            )

            if (reviewItem.isCertified) {
                Spacer(Modifier.width(4.dp))
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_all_auth_check_16),
                    contentDescription = null,
                    tint = Color.Unspecified,
                )
            }

            Spacer(Modifier.weight(1f))
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_all_star_16),
                contentDescription = null,
                tint = Color.Unspecified,
            )
            Spacer(Modifier.width(3.dp))
            Text(
                text = reviewItem.star.toString(),
                style = ArabyteTheme.typography.bodySemi13,
                color = ArabyteTheme.colors.black,
            )
        }

        Text(
            text = reviewItem.content,
            style = ArabyteTheme.typography.capMed11,
            color = ArabyteTheme.colors.gray07,
            minLines = 2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            ArabyteLocationChip(locationText = reviewItem.region)
            Spacer(Modifier.width(4.dp))
            ReviewCategoryChip(category = reviewItem.category)
        }
    }
}
