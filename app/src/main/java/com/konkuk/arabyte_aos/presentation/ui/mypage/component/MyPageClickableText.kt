package com.konkuk.arabyte_aos.presentation.ui.mypage.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun MyPageClickableText(
    text: String,
    clickable: () -> Unit,
    textColor: Color = ArabyteTheme.colors.black,
) {
    Text(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 20.dp).noRippleClickable(clickable), text = text, style = ArabyteTheme.typography.bodyMed15, color = textColor)
}
