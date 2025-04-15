package com.konkuk.arabyte_aos.presentation.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun LoginRoute(
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues = PaddingValues(0.dp),
    navigateToHome: () -> Unit,
    viewModel: LoginViewModel = hiltViewModel(),
) {
    LoginScreen(modifier = modifier, innerPaddingValues = innerPaddingValues, navigateToHome = navigateToHome)
}

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    innerPaddingValues: PaddingValues,
    navigateToHome: () -> Unit,
) {
    Column(
        modifier =
            modifier
                .fillMaxSize(),
    ) {
        Button(onClick = { navigateToHome() }) { Text("Home") }
    }
}
