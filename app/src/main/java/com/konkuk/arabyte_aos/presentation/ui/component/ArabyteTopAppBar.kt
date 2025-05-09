package com.konkuk.arabyte_aos.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

/**
 * 4가지 타입의 상단 앱 바를 나타내는 컴포넌트입니다.
 *
 * @param useBack Back 버튼 여부
 * @param title App Bar의 가운데 Title
 * @param optionalText App Bar의 우측 text (ex. 완료)
 * @param optionalIconRes App Bar의 우측 버튼 (ex. 더보기 버튼)
 */

@Composable
fun ArabyteTopAppBar(
    useBack: Boolean = true,
    title: String? = null,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
) {
    ArabyteTopAppBarInternal(
        modifier = modifier,
        useBack = useBack,
        title = title,
        onBackClick = onBackClick,
    )
}

@Composable
fun ArabyteTopAppBar(
    modifier: Modifier = Modifier,
    useBack: Boolean = true,
    title: String? = null,
    optionalText: String,
    onBackClick: () -> Unit = {},
    onOptionalClick: () -> Unit = {},
    optionalTextColor: Color = ArabyteTheme.colors.gray03,
) {
    ArabyteTopAppBarInternal(
        modifier = modifier,
        useBack = useBack,
        title = title,
        onBackClick = onBackClick,
        optionComponent = {
            Text(
                text = optionalText,
                style = ArabyteTheme.typography.bodySemi15,
                color = optionalTextColor,
                modifier =
                    Modifier
                        .padding(end = 16.dp)
                        .noRippleClickable { onOptionalClick() },
            )
        },
    )
}

@Composable
fun ArabyteTopAppBar(
    modifier: Modifier = Modifier,
    useBack: Boolean = true,
    title: String? = null,
    optionalIconRes: Int,
    onBackClick: () -> Unit = {},
    onOptionalClick: () -> Unit = {},
) {
    ArabyteTopAppBarInternal(
        modifier = modifier,
        useBack = useBack,
        title = title,
        onBackClick = onBackClick,
        optionComponent = {
            Icon(
                imageVector = ImageVector.vectorResource(id = optionalIconRes),
                contentDescription = null,
                modifier = Modifier.noRippleClickable { onOptionalClick() },
                tint = Color.Unspecified,
            )
        },
    )
}

@Composable
private fun ArabyteTopAppBarInternal(
    modifier: Modifier = Modifier,
    useBack: Boolean = true,
    title: String? = null,
    onBackClick: () -> Unit = {},
    optionComponent: @Composable () -> Unit = {},
) {
    Box(modifier = modifier.fillMaxWidth()) {
        if (useBack) {
            Icon(
                modifier =
                    Modifier
                        .noRippleClickable { onBackClick() }
                        .align(Alignment.CenterStart),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_all_back_button_45),
                contentDescription = null,
                tint = ArabyteTheme.colors.gray07,
            )
        }

        title?.let {
            Text(
                text = it,
                style = ArabyteTheme.typography.bodySemi15,
                color = ArabyteTheme.colors.black,
                modifier = Modifier.align(Alignment.Center),
            )
        }

        Box(modifier = Modifier.align(Alignment.CenterEnd)) {
            optionComponent()
        }
    }
}
