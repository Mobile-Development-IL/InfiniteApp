package com.infinitelearning.infiniteapp.presentation.screen.login

import android.widget.Toast
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.infinitelearning.infiniteapp.data.DataStore
import com.infinitelearning.infiniteapp.data.SharedPreferencesManager
import com.infinitelearning.infiniteapp.navigation.Screen
import com.infinitelearning.infiniteapp.presentation.screen.login.component.GoogleButton
import com.infinitelearning.infiniteapp.presentation.screen.login.component.NameTextField
import com.infinitelearning.infiniteapp.presentation.screen.login.component.PasswordTextField
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    val sharedPreferencesManager = remember {
        SharedPreferencesManager(context)
    }
    val dataStore = DataStore(context)

    var name by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }

    LoginContent(
        name = name,
        password = password,
        onNameChange = { name = it },
        onPasswordChange = { password = it },
        onLoginClick = {
            if (name.isBlank() || password.isBlank()){
                Toast.makeText(context, "Nama dan Password Wajib Diisi", Toast.LENGTH_SHORT).show()
            } else {
                sharedPreferencesManager.name = name
                sharedPreferencesManager.password = password
                coroutineScope.launch {
                    dataStore.saveStatus(true)
                }
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Login.route) {
                        inclusive = true
                    }
                }
            }
        },
        moveToForgot = {
            Toast.makeText(
                context,
                "Silahkan di kembangkan sendiri",
                Toast.LENGTH_SHORT
            ).show()
        },
        onGoogleClick = {
            Toast.makeText(
                context,
                "Nanti akan dibahas saat Materi Firebase",
                Toast.LENGTH_SHORT
            ).show()
        },
        onSignUpClick = {
            Toast.makeText(
                context,
                "Silahkan di kembangkan sendiri",
                Toast.LENGTH_SHORT
            ).show()
        },
        modifier = modifier
    )
}

@Composable
fun LoginContent(
    name: String,
    password: String,
    onNameChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onLoginClick: () -> Unit,
    moveToForgot: () -> Unit,
    onGoogleClick: () -> Unit,
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier,
    scrollState: ScrollState = rememberScrollState()
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Spacer(modifier = Modifier.height(100.dp))

            Text(
                text = "Masuk",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Medium
            )
            Text(
                text = "Untuk Belajar tentang Android Development",
                style = MaterialTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.Center
                ),
                modifier = Modifier
                    .padding(top = 4.dp)
            )
            Spacer(modifier = Modifier.height(64.dp))
            NameTextField(
                value = name,
                onValueChange = onNameChange,
                imageVector = Icons.Outlined.Person,
                contentDescription = "Icon Person",
                label = "Nama",
            )
            PasswordTextField(
                text = password,
                onValueChange = onPasswordChange,
                label = "Password"
            )
            TextButton(
                onClick = moveToForgot,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = "Lupa Kata Sandi?",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Button(
                onClick = onLoginClick,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = "Masuk",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Text(
                text = "atau",
                style = MaterialTheme.typography.bodyMedium
            )
            GoogleButton(
                clicked = onGoogleClick,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .height(48.dp)
            )
            Row(
                modifier = Modifier.padding(top = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Belum Punya Akun?")
                TextButton(onClick = onSignUpClick) {
                    Text(
                        text = "Daftar",
                        style = MaterialTheme.typography.bodyLarge
                    )
                }
            }
            Spacer(modifier = Modifier.height(128.dp))
        }
    }
}
