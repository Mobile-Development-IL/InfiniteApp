package com.rahmadev.storage.presentation.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun OutlinedTextFieldStyle(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    readOnly: Boolean,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label) },
        readOnly = readOnly,
        modifier = modifier.fillMaxWidth()
    )
}