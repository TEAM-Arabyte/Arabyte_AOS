package com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewDetailHeader(
    companyName: String,
    isCertified: Boolean,
    star: Int,
    region: String,
    category: ArabyteJobCategory,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .background(color = ArabyteTheme.colors.white)
                .padding(horizontal = 16.dp),
    ) {
        Spacer(modifier = Modifier.height(11.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = companyName, style = ArabyteTheme.typography.bodyBold17, color = ArabyteTheme.colors.black)
            if (isCertified) {
                Spacer(modifier = Modifier.width(4.dp))
                Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_auth_check_16), tint = Color.Unspecified, contentDescription = null, modifier = Modifier.size(20.dp))
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_star_16), tint = Color.Unspecified, contentDescription = null, modifier = Modifier.size(20.dp))
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = star.toString(), style = ArabyteTheme.typography.bodySemi17, color = ArabyteTheme.colors.black)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_location_15), contentDescription = null, tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(7.dp))
            Text(text = region, style = ArabyteTheme.typography.bodyMed13, color = ArabyteTheme.colors.black)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_category_15), contentDescription = null, tint = Color.Unspecified)
            Spacer(modifier = Modifier.width(7.dp))
            Text(text = category.label, style = ArabyteTheme.typography.bodyMed13, color = ArabyteTheme.colors.black)
        }
        Spacer(modifier = Modifier.height(19.dp))
    }
}

@Preview
@Composable
private fun ReviewDetailHeaderRowPreview() {
    ArabyteAOSTheme {
        ReviewDetailHeader(
            companyName = "메가커피 건대점",
            isCertified = true,
            star = 5,
            region = "서울특별시 광진구",
            category = ArabyteJobCategory.FOOD_BEVERAGE,
        )
    }
}
