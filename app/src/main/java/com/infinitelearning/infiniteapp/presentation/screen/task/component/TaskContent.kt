package com.infinitelearning.infiniteapp.presentation.screen.task.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rahmadev.storage.presentation.component.OutlinedTextFieldStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskContent(
    header: String,
    title: String,
    desc: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
    onTitleChange: (String) -> Unit = {},
    onDescChange: (String) -> Unit = {},
    onSaveFileClick: () -> Unit = {},
    readOnly: Boolean = false,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = header) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Arrow Back"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextFieldStyle(
                value = title, onValueChange = onTitleChange,
                label = "Tugas",
                readOnly = readOnly
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedTextFieldStyle(
                value = desc,
                onValueChange = onDescChange,
                label = "Deskripsi",
                readOnly = readOnly,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.height(24.dp))
            if (!readOnly)
                Button(
                    onClick = onSaveFileClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = MaterialTheme.shapes.medium
                ) {
                    Text(text = "Simpan")
                }
        }
    }
}