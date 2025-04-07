package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
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
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteAddPhotoButton(
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .roundedBackgroundWithPadding(cornerRadius = 7.dp, backgroundColor = ArabyteTheme.colors.gray01, padding = PaddingValues(vertical = 18.dp))
                .noRippleClickable { buttonClicked() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        Icon(imageVector = ImageVector.vectorResource(R.drawable.ic_all_camera_18), tint = Color.Unspecified, contentDescription = null)
        Spacer(modifier = Modifier.width(9.dp))
        Text(text = stringResource(R.string.button_add_photo), color = ArabyteTheme.colors.gray05, style = ArabyteTheme.typography.bodySemi13)
    }
}

@Preview
@Composable
private fun ArabyteAddPhotoButtonPreview() {
    ArabyteAOSTheme {
        ArabyteAddPhotoButton()
    }
}
