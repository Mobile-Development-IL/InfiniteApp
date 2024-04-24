package com.infinitelearning.infiniteapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.infinitelearning.infiniteapp.data.DummyData
import com.infinitelearning.infiniteapp.model.Mentee
import com.infinitelearning.infiniteapp.model.Mentor
import com.infinitelearning.infiniteapp.presentation.component.MenteeItem
import com.infinitelearning.infiniteapp.presentation.component.MentorItem

@Composable
fun InfiniteApp(
    mentors: List<Mentor>,
    mentees: List<Mentee>,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            LazyRow(
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
            ) {
                items(mentors) {
                    MentorItem(mentor = it)
                }
            }
        }
        items(mentees) {
            MenteeItem(mentee = it, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun InfiniteAppPrev() {
    InfiniteApp(
        mentors = DummyData.mobileMentors,
        mentees = DummyData.mobileMentees,
    )
}