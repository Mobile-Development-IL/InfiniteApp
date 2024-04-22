package com.infinitelearning.infiniteapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.infinitelearning.infiniteapp.data.DummyData
import com.infinitelearning.infiniteapp.model.Mentor
import com.infinitelearning.infiniteapp.presentation.component.MentorItem

@Composable
fun InfiniteApp(
    mentors: List<Mentor>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        mentors.forEach {
            MentorItem(mentor = it)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfiniteAppPrev() {
    InfiniteApp(mentors = DummyData.mobileMentors)
}