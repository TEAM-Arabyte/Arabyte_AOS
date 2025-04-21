package com.konkuk.arabyte_aos.presentation.ui.mypage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MyPageRoute(
    paddingValues: PaddingValues,
    // navigateToMyInfoS : () -> Unit,
    myPageViewModel: MyPageViewModel = hiltViewModel(),
) {
    MyPageScreen(
        paddingValues = paddingValues,
        myPageViewModel = myPageViewModel,
    )
}

@Composable
fun MyPageScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    // navigateToMyInfoS : () -> Unit,
    myPageViewModel: MyPageViewModel = hiltViewModel(),
) {
    Column(
        modifier =
            modifier
                .fillMaxSize(),
    ) {
        Text(text = "MyScreen")
    }
}
