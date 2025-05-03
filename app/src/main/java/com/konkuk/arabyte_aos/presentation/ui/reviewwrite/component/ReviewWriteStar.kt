package com.konkuk.arabyte_aos.presentation.ui.reviewwrite.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewWriteStar(
    modifier: Modifier = Modifier,
    selectedStar: Int = 1,
    onStarSelected: (Int) -> Unit,
) {
    Row(modifier = modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        repeat(5) { index ->
            val starIndex = index + 1
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_all_star_16),
                contentDescription = null,
                modifier =
                    Modifier
                        .size(30.dp)
                        .noRippleClickable { onStarSelected(starIndex) },
                tint = if (starIndex <= selectedStar) Color.Unspecified else ArabyteTheme.colors.gray01,
            )
        }
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = stringResource(R.string.review_write_star_rating_format,selectedStar), style = ArabyteTheme.typography.capSemi11, color = ArabyteTheme.colors.gray06)
    }
}

@Preview
@Composable
private fun ReviewWriteStarPreview() {
    ReviewWriteStar(
        selectedStar = 2,
        onStarSelected = {},
    )
}
