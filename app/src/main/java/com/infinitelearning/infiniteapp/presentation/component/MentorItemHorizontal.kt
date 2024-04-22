package com.infinitelearning.infiniteapp.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infinitelearning.infiniteapp.R
import com.infinitelearning.infiniteapp.model.Mentor
import com.infinitelearning.infiniteapp.ui.theme.InfiniteAppTheme

@Composable
fun MentorItemHorizontal(
    mentor: Mentor,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = mentor.photo),
            contentDescription = mentor.name, modifier = Modifier
                .clip(CircleShape)
                .size(80.dp)
        )
        Text(text = mentor.name, style = MaterialTheme.typography.titleMedium)
        Text(text = mentor.role, color = MaterialTheme.colorScheme.primary)
    }
}

@Preview(showBackground = true)
@Composable
private fun MentorItemHorizontalPreview() {
    InfiniteAppTheme {
        MentorItemHorizontal(mentor = Mentor(1, "Reza", "Mobile", R.drawable.reza))
    }
}