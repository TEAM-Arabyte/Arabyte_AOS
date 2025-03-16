package com.konkuk.arabyte_aos.presentation.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.presentation.util.modifier.roundedBackgroundWithPadding
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteToggleButton(
    enabled: Boolean,
    modifier: Modifier = Modifier,
    buttonClicked: (Boolean) -> Unit = {},
) {
    val backgroundColor = if (enabled) ArabyteTheme.colors.mainBlue else ArabyteTheme.colors.gray03
    Box(modifier = modifier.roundedBackgroundWithPadding(cornerRadius = 20.dp, backgroundColor = backgroundColor).noRippleClickable { buttonClicked(!enabled) }) {
        Row(modifier = Modifier.padding(2.5.dp)) {
            if (!enabled) Spacer(modifier = Modifier.width(15.dp))
            Spacer(modifier = Modifier.background(shape = CircleShape, color = ArabyteTheme.colors.white).size(15.dp))
            if (enabled) Spacer(modifier = Modifier.width(15.dp))
        }
    }
}

@Preview
@Composable
private fun ArabyteToggleButtonPreview() {
    var isEnabled by remember { mutableStateOf(true) }
    ArabyteAOSTheme {
        Column {
            ArabyteToggleButton(enabled = isEnabled, buttonClicked = { isEnabled = it })
        }
    }
}
