package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteAddPhotoSmallButton(
    modifier: Modifier = Modifier,
    buttonClicked: () -> Unit = {},
) {
    Icon(
        imageVector = ImageVector.vectorResource(R.drawable.ic_all_camera_18),
        tint = Color.Unspecified,
        contentDescription = null,
        modifier =
            modifier
                .border(width = 1.dp, color = ArabyteTheme.colors.gray02, shape = RoundedCornerShape(7.dp))
                .roundedBackgroundWithPadding(padding = PaddingValues(35.dp), backgroundColor = ArabyteTheme.colors.gray01, cornerRadius = 7.dp)
                .noRippleClickable { buttonClicked() },
    )
}

@Preview
@Composable
private fun ArabyteSmallButtonPreview() {
    ArabyteAddPhotoSmallButton()
}
