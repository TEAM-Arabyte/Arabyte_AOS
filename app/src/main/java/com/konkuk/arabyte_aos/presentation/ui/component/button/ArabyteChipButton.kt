package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun ArabyteChipButton(
    buttonText: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    buttonClicked: () -> Unit = {},
) {
    Text(
        modifier =
        modifier
            .then(
                if (enabled) Modifier.border(
                    width = 1.dp,
                    color = arabyteColors.mainBlue,
                    shape = RoundedCornerShape(20.dp)
                ) else Modifier
            )
            .roundedBackgroundWithPadding(
                backgroundColor = if (enabled) arabyteColors.lightBlue else arabyteColors.gray01,
                padding = PaddingValues(vertical = 6.dp, horizontal = 13.dp),
                cornerRadius = 20.dp,
            )
            .noRippleClickable {
                buttonClicked()
            },
        text = buttonText,
        color = if (enabled) arabyteColors.mainBlue else arabyteColors.gray05,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
private fun ArabyteChipButtonPreview() {
    Column {
        ArabyteChipButton(buttonText = "chip button")
        ArabyteChipButton(buttonText = "chip button", enabled = false)
    }
}
