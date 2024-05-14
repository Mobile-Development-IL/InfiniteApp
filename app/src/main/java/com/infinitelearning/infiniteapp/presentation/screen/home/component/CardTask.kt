package com.infinitelearning.infiniteapp.presentation.screen.home.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardTask(
    onTaskClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(onClick = onTaskClick, modifier = modifier.padding(horizontal = 16.dp)) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(120.dp)
        ) {
            AsyncImage(
                model = "https://reflex.dev/blog/background_task.jpg",
                contentDescription = "Background Task",
                contentScale = ContentScale.Crop,
                modifier = Modifier.alpha(0.5f)
            )
            Text(
                text = "Task", style = MaterialTheme.typography.displayMedium.copy(
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        }
    }
}