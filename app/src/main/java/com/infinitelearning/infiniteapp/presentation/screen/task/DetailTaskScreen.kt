package com.infinitelearning.infiniteapp.presentation.screen.task

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.infinitelearning.infiniteapp.presentation.screen.task.component.TaskContent
import com.infinitelearning.infiniteapp.utils.FileHelper

@Composable
fun DetailTaskScreen(
    navController: NavController,
    titleFile: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val readData = FileHelper.readFromFile(context, titleFile)
    val titleData = readData.fileName ?: ""
    val descData = readData.data ?: ""

    TaskContent(
        header = "Detail Task",
        title = titleData,
        desc = descData,
        readOnly = true,
        onBackClick = { navController.navigateUp() },
        modifier = modifier
    )
}