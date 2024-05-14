package com.infinitelearning.infiniteapp.presentation.screen.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun Header(
    name: String,
    onLogoutClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Column {
            Text(
                text = buildAnnotatedString {
                    append("Hello, ")
                    withStyle(style = SpanStyle(MaterialTheme.colorScheme.primary)) {
                        append(name)
                    }
                },
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )
            )
            Text(text = "Semangat Belajar", style = MaterialTheme.typography.bodyLarge)
        }
        IconButton(onClick = onLogoutClick) {
            Icon(imageVector = Icons.AutoMirrored.Filled.Logout, contentDescription = "Logout Icon")
        }
    }
}