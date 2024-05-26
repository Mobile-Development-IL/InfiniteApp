package com.infinitelearning.infiniteapp.presentation.screen.task

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.infinitelearning.infiniteapp.domain.model.FileModel
import com.infinitelearning.infiniteapp.presentation.screen.task.component.TaskContent
import com.infinitelearning.infiniteapp.utils.FileHelper

@Composable
fun AddTaskScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val fileModel = FileModel()

    var title by remember {
        mutableStateOf("")
    }
    var desc by remember {
        mutableStateOf("")
    }

    TaskContent(
        header = "Task Baru",
        title = title,
        onTitleChange = { title = it },
        desc = desc,
        onDescChange = { desc = it },
        onBackClick = { navController.navigateUp() },
        onSaveFileClick = {
            fileModel.fileName = title
            fileModel.data = desc
            FileHelper.writeToFile(fileModel, context)
            Toast.makeText(
                context,
                "Menyimpan File " + fileModel.fileName + "Berhasil",
                Toast.LENGTH_SHORT
            ).show()
            navController.navigateUp()
        },
        modifier = modifier
    )
}