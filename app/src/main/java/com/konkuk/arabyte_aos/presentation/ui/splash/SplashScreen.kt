package com.konkuk.arabyte_aos.presentation.ui.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun SplashScreen(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.mainBlue),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(207f))
        Text(
            text = stringResource(R.string.splash_service_description),
            style = ArabyteTheme.typography.bodyMed15,
            textAlign = TextAlign.Center,
            color = ArabyteTheme.colors.white,
        )
        Spacer(modifier = Modifier.weight(459f))
    }
}

@Preview
@Composable
private fun SplashScreenPreview() {
    ArabyteAOSTheme { SplashScreen() }
}
