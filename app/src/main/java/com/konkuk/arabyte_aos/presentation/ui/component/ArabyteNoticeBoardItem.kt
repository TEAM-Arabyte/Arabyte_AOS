package com.konkuk.arabyte_aos.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.type.component.ArabyteBoardCategoryType
import com.konkuk.arabyte_aos.presentation.ui.component.chip.CommentChip
import com.konkuk.arabyte_aos.presentation.ui.component.chip.LikeChip
import com.konkuk.arabyte_aos.presentation.ui.noticeboard.component.NoticeBoardCategoryChip
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteAOSTheme
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme
import com.konkuk.arabyte_aos.ui.theme.arabyteColors

@Composable
fun ArabyteNoticeBoardItem(
    title: String,
    text: String,
    likeCount: Int,
    commentCount: Int,
    uploadAt: String,
    thumbnailImage: String,
    articleCategoryType: ArabyteBoardCategoryType,
    isLiked: Boolean,
    modifier: Modifier = Modifier,
    navigateToReviewDetail: () -> Unit = {},
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .noRippleClickable(navigateToReviewDetail),
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 11.dp),
        ) {
            NoticeBoardCategoryChip(
                categoryResId = articleCategoryType.stringRes,
            )
            Spacer(Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.weight(1f),
                ) {
                    Text(
                        text = title,
                        style = ArabyteTheme.typography.bodySemi13,
                        color = arabyteColors.gray08,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = text,
                        style = ArabyteTheme.typography.capMed11,
                        color = arabyteColors.gray06,
                        maxLines = 2,
                        minLines = 2,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
                if (thumbnailImage.isNotBlank()) {
                    Spacer(Modifier.width(8.dp))
                    AsyncImage(
                        model = thumbnailImage,
                        contentDescription = null,
                        modifier =
                            Modifier
                                .size(52.dp)
                                .clip(RoundedCornerShape(3.dp)),
                        contentScale = ContentScale.Crop,
                        placeholder = painterResource(id = R.drawable.img_notice_board_image_load),
                    )
                }
            }
            Spacer(Modifier.height(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = uploadAt,
                    style = ArabyteTheme.typography.capMed9,
                    color = arabyteColors.gray05,
                )
                Spacer(modifier = Modifier.weight(1f))
                LikeChip(
                    count = likeCount,
                    isLiked = isLiked,
                )
                Spacer(Modifier.width(7.dp))
                CommentChip(count = commentCount)
            }
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = arabyteColors.gray01,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ArabyteNoticeBoardItemPreview() {
    ArabyteAOSTheme {
        ArabyteNoticeBoardItem(
            title = "최악의 알바 후기",
            text = "솔직히 이렇게까지 힘들 줄 몰랐어요. 가게 사장님은 약속한 시급보다 적게 주고, 근무 환경도 엉망이었어요... 여러분들은 알바 구하실 때 꼭 이건 알고가...",
            likeCount = 5,
            commentCount = 5,
            uploadAt = "10분 전",
            thumbnailImage = "..",
            articleCategoryType = ArabyteBoardCategoryType.FREE,
            isLiked = true,
        )
    }
}
