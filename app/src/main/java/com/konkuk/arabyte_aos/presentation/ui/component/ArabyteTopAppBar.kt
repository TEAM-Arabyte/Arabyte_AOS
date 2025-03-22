package com.konkuk.arabyte_aos.presentation.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.konkuk.arabyte_aos.presentation.type.ArabyteTopAppBarType
import com.konkuk.arabyte_aos.presentation.util.modifier.noRippleClickable
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun ArabyteTopAppBar(
    appBarType: ArabyteTopAppBarType,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onOptionalClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier.fillMaxWidth(),
    ) {
        Icon(
            modifier =
                Modifier
                    .noRippleClickable { onBackClick() }
                    .align(Alignment.CenterStart),
            imageVector = ImageVector.vectorResource(id = appBarType.backButtonIconRes),
            contentDescription = null,
        )
        if (appBarType is ArabyteTopAppBarType.BackButtonWithTitle ||
            appBarType is ArabyteTopAppBarType.BackButtonWithTitleAndOption
        ) {
            Text(
                text =
                    stringResource(
                        id =
                            (appBarType as? ArabyteTopAppBarType.BackButtonWithTitle)?.titleStringRes
                                ?: (appBarType as ArabyteTopAppBarType.BackButtonWithTitleAndOption).titleStringRes,
                    ),
                style = ArabyteTheme.typography.bodySemi15,
                color = ArabyteTheme.colors.black,
                modifier = Modifier.align(Alignment.Center),
            )
        }
        when (appBarType) {
            is ArabyteTopAppBarType.BackButtonWithTitleAndOption -> {
                Text(
                    text = stringResource(id = appBarType.optionalButtonStringRes),
                    style = ArabyteTheme.typography.bodySemi15,
                    color = ArabyteTheme.colors.gray03,
                    modifier =
                        Modifier
                            .padding(end = 16.dp)
                            .noRippleClickable {
                                if (onOptionalClick != null) {
                                    onOptionalClick()
                                }
                            }
                            .align(Alignment.CenterEnd),
                )
            }

            is ArabyteTopAppBarType.BackButtonWithOptionalIcon -> {
                Icon(
                    imageVector = ImageVector.vectorResource(id = appBarType.optionalIconRes),
                    contentDescription = null,
                    modifier =
                        Modifier
                            .noRippleClickable {
                                if (onOptionalClick != null) {
                                    onOptionalClick()
                                }
                            }
                            .align(Alignment.CenterEnd),
                )
            }
            else -> {}
        }
    }
}
