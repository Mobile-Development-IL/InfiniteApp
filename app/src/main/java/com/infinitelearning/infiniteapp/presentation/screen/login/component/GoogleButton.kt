package com.infinitelearning.infiniteapp.presentation.screen.login.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.infinitelearning.infiniteapp.R

@Composable
fun GoogleButton(
    clicked: () -> Unit,
    modifier: Modifier = Modifier,
    isConnectLoading: Boolean = false
) {

    OutlinedButton(
        onClick = clicked,
        shape = MaterialTheme.shapes.large,
        modifier = modifier.fillMaxWidth()
    ) {
        if (isConnectLoading) {
            CircularProgressIndicator(
                color = MaterialTheme.colorScheme.primary,
                strokeWidth = 3.dp,
                modifier = Modifier
                    .size(32.dp)
            )
        } else {
            Icon(
                painter = painterResource(R.drawable.google_icon),
                contentDescription = "Google Icon",
                tint = Color.Unspecified
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = "Sambungkan dengan Google",
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}