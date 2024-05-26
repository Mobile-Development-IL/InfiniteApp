package com.infinitelearning.infiniteapp.presentation.screen.home.component

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import com.infinitelearning.infiniteapp.domain.model.Mentee
import com.infinitelearning.infiniteapp.ui.theme.InfiniteAppTheme

@Composable
fun MenteeItem(
    mentee: Mentee,
    modifier: Modifier = Modifier,
    context: Context = LocalContext.current,
    onItemClick: (Int) -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .clickable{ onItemClick(mentee.id) }
    ) {
        AsyncImage(
            model = mentee.photo,
            imageLoader = ImageLoader(context),
            contentDescription = mentee.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = mentee.name, style = MaterialTheme.typography.titleMedium)
            Row {
                Text(text = mentee.role, color = MaterialTheme.colorScheme.primary)
                Text(text = " - ${mentee.batch}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun MentorItemPreview() {
    InfiniteAppTheme {
        MenteeItem(
            mentee = Mentee(
                1,
                "Nama Mentee",
                "https://cdn.pixabay.com/photo/2015/10/05/22/37/blank-profile-picture-973460_960_720.png",
                "Batch 7",
                "Mentee Mobile"
            ),
            onItemClick = { _ -> }
        )
    }
}