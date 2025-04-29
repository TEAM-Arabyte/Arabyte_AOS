package com.konkuk.arabyte_aos.presentation.ui.mypage

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.LocalLifecycleOwner
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.flowWithLifecycle
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable

@Composable
fun MyPageRoute(
    paddingValues: PaddingValues,
    navigateToLogin: () -> Unit,
    myPageViewModel: MyPageViewModel = hiltViewModel(),
) {
    val uiState by myPageViewModel.uiState.collectAsStateWithLifecycle()

    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(myPageViewModel.sideEffect, lifecycleOwner) {
        myPageViewModel.sideEffect.flowWithLifecycle(lifecycle = lifecycleOwner.lifecycle)
            .collect { sideEffect ->
                when (sideEffect) {
                    is MyPageContract.MyPageSideEffect.NavigateToLogin -> navigateToLogin()
                }
            }
    }

    MyPageScreen(
        paddingValues = paddingValues,
        uiState = uiState,
        withDrawClicked = { myPageViewModel.setEvent(MyPageContract.MyPageEvent.WithDrawClicked) },
    )
}

@Composable
fun MyPageScreen(
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier,
    uiState: MyPageContract.MyPageUiState = MyPageContract.MyPageUiState(),
    withDrawClicked: () -> Unit = {},
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(paddingValues),
    ) {
        Text(text = "MyScreen")
        Text(text = "회원탈퇴", modifier = Modifier.noRippleClickable(withDrawClicked))
    }
}
