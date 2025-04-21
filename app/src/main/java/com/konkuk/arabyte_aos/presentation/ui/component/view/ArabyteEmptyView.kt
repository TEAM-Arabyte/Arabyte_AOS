package com.konkuk.arabyte_aos.presentation.ui.component.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteEmptyView(modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize().background(color = ArabyteTheme.colors.white), contentAlignment = Alignment.Center) {
        Text(text = "아무것도 없지롱~", color = ArabyteTheme.colors.gray05)
    }
}

@Preview
@Composable
private fun ArabyteEmptyViewPreview() {
    ArabyteAOSTheme {
        ArabyteEmptyView()
    }
}
