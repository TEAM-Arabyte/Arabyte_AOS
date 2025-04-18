package com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.ReviewRating
import com.konkuk.arabyte_aos.domain.model.toTitleLabelList
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewDetailRating(
    reviewRating: ReviewRating,
    modifier: Modifier = Modifier,
) {
    val titleLabelList = reviewRating.toTitleLabelList()

    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .background(color = ArabyteTheme.colors.white)
                .padding(horizontal = 16.dp, vertical = 13.dp),
    ) {
        Row {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_search_27), contentDescription = null, tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = "알바 리뷰", style = ArabyteTheme.typography.bodyBold15, color = ArabyteTheme.colors.black)
        }
        Spacer(modifier = Modifier.height(4.dp))
        titleLabelList.forEachIndexed { index, (title, label) ->
            RatingRow(title = title, label = label)
            if (index != titleLabelList.lastIndex) {
                HorizontalDivider(thickness = 1.dp, color = ArabyteTheme.colors.gray01)
            }
        }
    }
}

@Composable
private fun RatingRow(
    title: String,
    label: String,
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .padding(top = 9.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            text = title,
            style = ArabyteTheme.typography.bodyMed13,
            color = ArabyteTheme.colors.black,
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            modifier = Modifier.roundedBackgroundWithPadding(padding = PaddingValues(vertical = 5.dp, horizontal = 8.dp), cornerRadius = 3.dp, backgroundColor = ArabyteTheme.colors.gray01),
            text = label,
            style = ArabyteTheme.typography.capSemi11,
            color = ArabyteTheme.colors.gray06,
        )
    }
}
