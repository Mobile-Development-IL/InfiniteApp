package com.infinitelearning.infiniteapp.presentation.screen.alarm.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp

@Composable
fun ScheduleDateTextField(
    value: String,
    label: String,
    icon: ImageVector,
    onValueChange: (String) -> Unit,
    onIconClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Done
        ),
        shape = RoundedCornerShape(8.dp),
        trailingIcon = {
            IconButton(onClick = onIconClick) {
                Icon(
                    imageVector = icon, contentDescription = "Icon Tanggal",
                    tint = Color.Black
                )
            }
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    )
}