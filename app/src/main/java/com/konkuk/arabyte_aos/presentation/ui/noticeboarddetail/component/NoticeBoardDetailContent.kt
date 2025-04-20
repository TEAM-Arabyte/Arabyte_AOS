package com.konkuk.arabyte_aos.presentation.ui.noticeboarddetail.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.konkuk.arabyte_aos.R
import com.konkuk.arabyte_aos.presentation.model.NoticeBoardDetailComment
import com.konkuk.arabyte_aos.presentation.ui.component.button.ArabyteLikeButton
import com.konkuk.arabyte_aos.ui.theme.ArabyteTheme

@Composable
fun NoticeBoardDetailContent(
    writerProfileImage:String,
    writerNickname:String,
    writeDate:String,
    title:String,
    content:String,
    isLiked:Boolean,
    modifier: Modifier = Modifier) {
    Column (modifier = modifier
        .fillMaxWidth()
        .background(color = ArabyteTheme.colors.white)
        .padding(vertical = 11.dp, horizontal = 16.dp)){
        Row {
            if (writerProfileImage.isBlank()) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.img_profile_default_male),
                    contentDescription = null,
                    modifier = Modifier.size(50.dp)
                )
            } else {
                AsyncImage(
                    model = writerProfileImage,
                    contentDescription = null,
                    modifier = Modifier.size(50.dp),
                    contentScale = ContentScale.Crop,
                    placeholder = painterResource(R.drawable.img_profile_default_anonymity),
                    error = painterResource(R.drawable.img_profile_default_anonymity)
                )
            }
            Column {
                Text(text = writerNickname, style = ArabyteTheme.typography.capSemi11, color = ArabyteTheme.colors.gray07)
                Text(text = writeDate, style = ArabyteTheme.typography.capMed9, color = ArabyteTheme.colors.gray05)
            }
        }
        Spacer(modifier = Modifier.height(14.dp))
        Text(text = title, style = ArabyteTheme.typography.bodyBold15, color = ArabyteTheme.colors.gray08)
        Spacer(modifier = Modifier.height(9.dp))
        Text(text = content, style = ArabyteTheme.typography.bodyMed13, color = ArabyteTheme.colors.gray06)
        Spacer(modifier = Modifier.height(12.dp))
        ArabyteLikeButton(modifier = Modifier.align(Alignment.End), enabled = isLiked)
    }
}