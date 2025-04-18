package com.konkuk.arabyte_aos.presentation.ui.reviewdetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.domain.model.Overtime
import com.konkuk.arabyte_aos.domain.model.ReviewDetail
import com.konkuk.arabyte_aos.domain.model.ReviewRating
import com.konkuk.arabyte_aos.domain.model.Salary
import com.konkuk.arabyte_aos.domain.model.SalaryDate
import com.konkuk.arabyte_aos.domain.model.WorkAtmosphere
import com.konkuk.arabyte_aos.domain.model.WorkDifficulty
import com.konkuk.arabyte_aos.domain.model.WorkIntensity
import com.konkuk.arabyte_aos.presentation.model.ArabyteJobCategory
import com.konkuk.arabyte_aos.presentation.ui.component.ArabyteTopAppBar
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component.ReviewDetailContent
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component.ReviewDetailHeader
import com.konkuk.arabyte_aos.presentation.ui.reviewdetail.component.ReviewDetailRating
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ReviewDetailRoute(modifier: Modifier = Modifier) {

}

@Composable
fun ReviewDetailScreen(reviewDetail: ReviewDetail, modifier: Modifier = Modifier, innerPaddingValues: PaddingValues = PaddingValues(0.dp)) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ArabyteTheme.colors.white)
            .padding(innerPaddingValues)
    ) {
        ArabyteTopAppBar(
            useBack = true,
            onBackClick = {},
            optionalIconRes = R.drawable.ic_all_optional_button_45,
            onOptionalClick = {}
        )
        LazyColumn {
            item {
                ReviewDetailHeader(
                    companyName = reviewDetail.companyName,
                    isCertified = reviewDetail.isCertified,
                    star = reviewDetail.star,
                    region = reviewDetail.region,
                    category = reviewDetail.category,
                )
            }
            item {
                HorizontalDivider(thickness = 5.dp, color = ArabyteTheme.colors.gray01)
            }
            item {
                ReviewDetailRating(
                    reviewRating = reviewDetail.reviewRating,
                )
            }
            item {
                ReviewDetailContent(
                    content = reviewDetail.reviewContent,
                )
            }
        }
    }
}

@Preview
@Composable
private fun ReviewDetailScreenPreview() {
    ArabyteAOSTheme {
        ReviewDetailScreen(
            reviewDetail = ReviewDetail(
                reviewId = 1,
                companyName = "메가커피 건대점",
                isCertified = true,
                star = 5.0f,
                region = "서울특별시 광진구",
                category = ArabyteJobCategory.FOOD,
                reviewRating = ReviewRating(
                    workIntensity = WorkIntensity.LIGHT,
                    workAtmosphere = WorkAtmosphere.RIGID,
                    salary = Salary.MINIMUM,
                    salaryDate = SalaryDate.REGULARLY,
                    overtime = Overtime.SOMETIMES,
                    workDifficulty = WorkDifficulty.MODERATE
                ),
                reviewContent = "처음 카페 알바를 시작했는데, 교육을 친절하게 해주셔서 금방 적응할 수 있었습니다. 기본적인 음료 제조부터 계산까지 차근차근 배울 수 있어서 좋았어요.\n" +
                        "\n" +
                        "특히 메뉴별 레시피를 자세히 알려주셔서 실수 없이 만들 수 있었고, 실습 위주로 교육해 주셔서 빠르게 익힐 수 있었습니다. 동료 직원분들도 친절해서 모르는 게 있으면 바로 물어볼 수 있었고, 실수해도 잘 설명해 주셔서 부담 없이 일할 수 있었어요.\n" +
                        "\n" +
                        "매장 분위기도 전체적으로 활기차고 편안해서 일하면서 크게 스트레스 받지 않았습니다. 바쁜 시간대에는 정신없긴 했지만, 덕분에 빠르게 업무에 익숙해질 수 있었어요.\n" +
                        "\n" +
                        "첫 알바로 추천할 만한 곳입니다! \uD83D\uDE0A"
            )
        )
    }
}

