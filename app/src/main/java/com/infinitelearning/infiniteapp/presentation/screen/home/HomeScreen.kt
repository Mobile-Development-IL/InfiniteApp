package com.infinitelearning.infiniteapp.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.infinitelearning.infiniteapp.data.DataStore
import com.infinitelearning.infiniteapp.data.DummyData
import com.infinitelearning.infiniteapp.data.SharedPreferencesManager
import com.infinitelearning.infiniteapp.model.Mentee
import com.infinitelearning.infiniteapp.model.Mentor
import com.infinitelearning.infiniteapp.navigation.Screen
import com.infinitelearning.infiniteapp.presentation.component.MenteeItem
import com.infinitelearning.infiniteapp.presentation.component.MentorItem
import com.infinitelearning.infiniteapp.presentation.screen.home.component.CardTask
import com.infinitelearning.infiniteapp.presentation.screen.home.component.Header
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()
    val mentors = DummyData.mobileMentors
    val mentees = DummyData.mobileMentees

    val sharedPreferencesManager = remember {
        SharedPreferencesManager(context)
    }
    val dataStore = DataStore(context)

    val name = sharedPreferencesManager.name ?: ""

    HomeContent(
        navController = navController,
        name = name,
        mentors = mentors,
        mentees = mentees,
        onLogoutClick = {
            sharedPreferencesManager.clear()
            coroutineScope.launch {
                dataStore.clearStatus()
            }
            navController.navigate(Screen.Login.route) {
                popUpTo(Screen.Home.route) {
                    inclusive = true
                }
            }
        },
        modifier = modifier
    )
}

@Composable
fun HomeContent(
    navController: NavController,
    name: String,
    mentors: List<Mentor>,
    mentees: List<Mentee>,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        item {
            Header(
                name = name,
                onLogoutClick = onLogoutClick,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            CardTask(onTaskClick = { navController.navigate(Screen.Task.route) })
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
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
