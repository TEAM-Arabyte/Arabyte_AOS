package com.konkuk.arabyte_aos.presentation.ui.mypage.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteSelectSmallButton
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun MyPageProfileRow(
    profileImage: String,
    defaultProfileRes: Int,
    nickname: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier =
            modifier
                .fillMaxWidth()
                .padding(16.dp).noRippleClickable(onClick),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        if (profileImage.isBlank()) {
            Image(
                painter = painterResource(defaultProfileRes),
                contentDescription = null,
                modifier = Modifier.size(50.dp),
            )
        } else {
            AsyncImage(
                model = profileImage,
                contentDescription = null,
                modifier = Modifier.size(50.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.img_profile_default_anonymity),
                error = painterResource(R.drawable.img_profile_default_anonymity),
            )
        }
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text =
                buildAnnotatedString {
                    append("안녕하세요!\n")
                    withStyle(style = SpanStyle(color = ArabyteTheme.colors.mainBlue)) {
                        append(nickname)
                    }
                    append("님")
                },
            style = ArabyteTheme.typography.bodySemi17,
            color = ArabyteTheme.colors.black,
        )
        Spacer(modifier = Modifier.weight(1f))
        ArabyteSelectSmallButton(
            buttonText = "프로필 확인",
            enabled = false,
            buttonClicked = onClick,
        )
    }
}

@Preview
@Composable
private fun MyPageProfileRowPreview() {
    ArabyteAOSTheme {
        MyPageProfileRow(
            profileImage = "",
            defaultProfileRes = 0,
            nickname = "나야알바",
            onClick = {},
        )
    }
}
