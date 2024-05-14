package com.rahmadev.storage.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.infinitelearning.infiniteapp.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CardItem(
    navController: NavController,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = { navController.navigate(Screen.DetailTask.createRoute(title)) },
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
    }
}