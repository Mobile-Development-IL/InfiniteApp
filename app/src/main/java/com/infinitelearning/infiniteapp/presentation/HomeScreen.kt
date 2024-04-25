package com.infinitelearning.infiniteapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.infinitelearning.infiniteapp.data.DummyData
import com.infinitelearning.infiniteapp.model.Mentee
import com.infinitelearning.infiniteapp.model.Mentor
import com.infinitelearning.infiniteapp.navigation.Screen
import com.infinitelearning.infiniteapp.presentation.component.MenteeItem
import com.infinitelearning.infiniteapp.presentation.component.MentorItem

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    mentors: List<Mentor> = DummyData.mobileMentors,
    mentees: List<Mentee> = DummyData.mobileMentees,
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
                items(mentors, key = { it.id }) {
                    MentorItem(mentor = it) { mentorId ->
                        navController.navigate(Screen.Detail.route + "/$mentorId")
                    }
                }
            }
        }
        items(mentees, key = { it.id }) {
            MenteeItem(mentee = it, modifier = Modifier.padding(horizontal = 16.dp))
        }
    }
}