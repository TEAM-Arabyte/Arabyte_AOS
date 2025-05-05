package com.konkuk.arabyte_aos.presentation.ui.mypage.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun MyPageProfileDataText(
    title: String,
    data: String,
) {
    Box(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp, horizontal = 16.dp)) {
        Text(text = title, style = ArabyteTheme.typography.bodyMed15, color = ArabyteTheme.colors.gray06)
        Text(text = data, modifier = Modifier.padding(start = 63.dp), style = ArabyteTheme.typography.bodySemi15, color = ArabyteTheme.colors.gray07)
    }
}
