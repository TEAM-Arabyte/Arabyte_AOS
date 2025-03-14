package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme.colors

@Composable
fun ArabyteSmallButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonClicked: () -> Unit = {},
) {
    Text(
        modifier =
            modifier
                .fillMaxWidth()
                .roundedBackgroundWithPadding(
                    backgroundColor = if (enabled) ArabyteTheme.colors.gray07 else ArabyteTheme.colors.gray01,
                    padding = PaddingValues(vertical = 16.dp),
                    cornerRadius = 9.dp,
                )
                .noRippleClickable {
                    buttonClicked()
                },
        text = buttonText,
        color = if (enabled) ArabyteTheme.colors.white else ArabyteTheme.colors.gray05,
        textAlign = TextAlign.Center,
        style = ArabyteTheme.typography.bodySemi15,
    )
}

@Preview
@Composable
private fun ArabyteSmallButtonPreview() {
    Column {
        ArabyteSmallButton(buttonText = "Button")
        ArabyteSmallButton(buttonText = "Button", enabled = false)
    }
}
