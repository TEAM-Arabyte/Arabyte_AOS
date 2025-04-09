package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteLocationButton(
    title: String,
    modifier: Modifier = Modifier,
    onClicked: () -> Unit = {},
    location: String = title,
    isSelected: Boolean = false,
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth(),
    ) {
        Text(text = title, style = ArabyteTheme.typography.bodySemi15)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .noRippleClickable { onClicked() },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier =
                    Modifier
                        .weight(1f)
                        .roundedBackgroundWithPadding(
                            backgroundColor = ArabyteTheme.colors.gray01,
                            cornerRadius = 9.dp,
                        )
                        .padding(horizontal = 10.dp, vertical = 15.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = location,
                    style = ArabyteTheme.typography.bodySemi13,
                    color = if (isSelected) ArabyteTheme.colors.black else ArabyteTheme.colors.gray03,
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_arrow_down_13), tint = Color.Unspecified, contentDescription = null)
            }
        }
        Spacer(modifier = Modifier.height(4.dp))
    }
}

@Preview
@Composable
private fun ArabyteLocationButtonPreview() {
    ArabyteAOSTheme {
        Column(modifier = Modifier.background(color = ArabyteTheme.colors.white)) {
            ArabyteLocationButton(
                title = "title",
                location = "location Unselected",
            )
            ArabyteLocationButton(
                title = "title",
                location = "location Selected",
                isSelected = true,
            )
        }
    }
}
