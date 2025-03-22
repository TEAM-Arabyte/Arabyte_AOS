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
import com.konkuk.arabyte_aos.presentation.ui.component.chip.ArabyteLocationChip
import com.konkuk.arabyte_aos.presentation.ui.review.component.ReviewCategoryChip
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteReviewItem(
    modifier: Modifier = Modifier,
    companyName: String,
    isCertified: Boolean = false,
    starRate: Double,
    reviewContent: String,
    location: String,
    category: Int,
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
                text = companyName,
                style = ArabyteTheme.typography.bodyBold13,
                color = ArabyteTheme.colors.black,
            )
            val icons = mutableListOf<ImageVector>()
            if (isCertified) icons.add(ImageVector.vectorResource(id = R.drawable.ic_all_auth_check_16))
            icons.forEach { icons ->
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
                text = starRate.toString(),
                style = ArabyteTheme.typography.bodySemi13,
                color = ArabyteTheme.colors.black,
            )
        }

        Text(
            text = reviewContent,
            style = ArabyteTheme.typography.capMed11,
            color = ArabyteTheme.colors.gray07,
            minLines = 2,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
        )

        Row {
            ArabyteLocationChip(locationText = location)
            Spacer(Modifier.width(4.dp))
            ReviewCategoryChip(categoryResId = category)
        }
    }
}
