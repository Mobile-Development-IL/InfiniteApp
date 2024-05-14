package com.infinitelearning.infiniteapp.presentation.screen.task

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.infinitelearning.infiniteapp.navigation.Screen
import com.rahmadev.storage.presentation.component.CardItem

@Composable
fun TaskScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val noteList =
        context.fileList().filter { fileName -> (fileName != "profileInstalled") }.toTypedArray()

    TaskContents(
        navController = navController,
        onBackClick = { navController.navigateUp() },
        onFabClick = { navController.navigate(Screen.AddTask.route) },
        taskList = noteList,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskContents(
    navController: NavController,
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    onFabClick: () -> Unit,
    taskList: Array<String>,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Task") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Arrow Back Icon"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onFabClick) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add Icon")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier.padding(innerPadding)
        ) {
            items(taskList) { item ->
                CardItem(title = item, navController = navController)
            }
        }
    }
}
