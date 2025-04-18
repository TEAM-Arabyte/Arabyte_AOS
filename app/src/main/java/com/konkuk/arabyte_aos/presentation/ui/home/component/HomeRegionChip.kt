package com.konkuk.arabyte_aos.presentation.ui.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun HomeRegionChip(
    region: String,
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
) {
    val (borderColor, backgroundColor, textColor) = Triple(ArabyteTheme.colors.mainBlue, ArabyteTheme.colors.lightBlue, ArabyteTheme.colors.mainBlue)
    Row(
        modifier =
            modifier
                .border(shape = RoundedCornerShape(30.dp), width = 1.dp, color = borderColor)
                .roundedBackgroundWithPadding(cornerRadius = 20.dp, backgroundColor = backgroundColor, padding = PaddingValues(horizontal = 8.dp, vertical = 4.dp))
                .noRippleClickable { buttonClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_all_location_15), tint = arabyteColors.mainBlue, contentDescription = null)
        Spacer(modifier = Modifier.width(2.dp))
        Text(text = region, color = textColor, style = ArabyteTheme.typography.capSemi11)
    }
}

@Preview(showBackground = true)
@Composable
private fun ArabyteAddPhotoButtonPreview() {
    ArabyteAOSTheme {
        HomeRegionChip(
            region = "서울특별시 강남구 개포2동",
        )
    }
}
