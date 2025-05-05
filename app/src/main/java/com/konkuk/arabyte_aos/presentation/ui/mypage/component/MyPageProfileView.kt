package com.konkuk.arabyte_aos.presentation.ui.mypage.component

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.model.Gender
import com.konkuk.arabyte_aos.presentation.model.UserProfile
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun MyPageProfileView(
    profileImageRes: String,
    defaultProfileRes: Int,
    userProfile: UserProfile,
    backButtonClicked: () -> Unit,
    modifier: Modifier = Modifier,
) {
    BackHandler {
        backButtonClicked()
    }

    Column(
        modifier =
            modifier
                .fillMaxSize()
                .background(color = ArabyteTheme.colors.white),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        ArabyteTopAppBar(
            modifier = modifier,
            useBack = true,
            title = "프로필 정보",
            onBackClick = backButtonClicked,
        )
        Spacer(modifier = Modifier.height(17.dp))
        if (profileImageRes.isBlank()) {
            Image(
                painter = painterResource(defaultProfileRes),
                contentDescription = null,
                modifier = Modifier.size(70.dp),
            )
        } else {
            AsyncImage(
                model = profileImageRes,
                contentDescription = null,
                modifier = Modifier.size(70.dp),
                contentScale = ContentScale.Crop,
                placeholder = painterResource(R.drawable.img_profile_default_anonymity),
                error = painterResource(R.drawable.img_profile_default_anonymity),
            )
        }
        Spacer(modifier = Modifier.height(14.dp))
        Text(text = userProfile.userName, style = ArabyteTheme.typography.bodySemi15, color = ArabyteTheme.colors.black)
        Spacer(modifier = Modifier.height(19.dp))
        HorizontalDivider(thickness = 8.dp, color = ArabyteTheme.colors.gray01)
        Text(
            text = "기본 정보",
            style = ArabyteTheme.typography.bodySemi15,
            color = ArabyteTheme.colors.gray08,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 16.dp),
        )
        Spacer(modifier = Modifier.height(5.dp))
        MyPageProfileDataText(
            title = "거주지",
            data = userProfile.location,
        )
        MyPageProfileDataText(
            title = "나이",
            data = userProfile.age,
        )
        MyPageProfileDataText(
            title = "성별",
            data = userProfile.gender.label,
        )
        HorizontalDivider(thickness = 8.dp, color = ArabyteTheme.colors.gray01)
        Text(
            text = "부가 정보",
            style = ArabyteTheme.typography.bodySemi15,
            color = ArabyteTheme.colors.gray08,
            modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 16.dp),
        )
        Spacer(modifier = Modifier.height(5.dp))
        MyPageProfileDataText(
            title = "알바 경력",
            data = "${userProfile.experienceYears}년 ${userProfile.experienceMonths}개월",
        )
        MyPageProfileDataText(
            title = "관심 직정",
            data = "${userProfile.jobInterests}",
        )
    }
}

@Preview
@Composable
private fun MyPageProfileViewPreview() {
    ArabyteAOSTheme {
        MyPageProfileView(
            profileImageRes = "",
            defaultProfileRes = 0,
            backButtonClicked = {},
            userProfile =
                UserProfile(
                    userName = "나야 알바",
                    location = "서울특별시 강남구",
                    age = "20대 초반",
                    gender = Gender.FEMALE,
                    experienceYears = 3,
                    experienceMonths = 4,
                    jobInterests = listOf(ArabyteJobCategory.DELIVERY, ArabyteJobCategory.FOOD_BEVERAGE),
                ),
        )
    }
}
