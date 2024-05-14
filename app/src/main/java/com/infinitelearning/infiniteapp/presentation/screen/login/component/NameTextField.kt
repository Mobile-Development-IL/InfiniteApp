package com.infinitelearning.infiniteapp.presentation.screen.login.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun NameTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    imageVector: ImageVector,
    contentDescription: String,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        value = value,
        shape = MaterialTheme.shapes.medium,
        onValueChange = onValueChange,
        leadingIcon = {
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription
            )
        },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii),
        label = { Text(text = label) },
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )
}