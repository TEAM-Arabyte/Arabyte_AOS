package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteAddFloatingButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
) {
    Row(
        modifier =
            modifier
                .roundedBackgroundWithPadding(cornerRadius = 20.dp, backgroundColor = ArabyteTheme.colors.mainBlue, padding = PaddingValues(vertical = 10.dp, horizontal = 14.dp))
                .noRippleClickable { buttonClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Text(text = buttonText, color = ArabyteTheme.colors.white, style = ArabyteTheme.typography.bodySemi15)
        Spacer(modifier = Modifier.width(3.dp))
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_floating_button_plus_16), tint = Color.Unspecified, contentDescription = null)
    }
}

@Preview
@Composable
private fun ArabyteAddPhotoButtonPreview() {
    ArabyteAOSTheme {
        ArabyteAddFloatingButton(buttonText = "Button")
    }
}
