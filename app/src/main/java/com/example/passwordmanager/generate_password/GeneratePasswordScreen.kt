package com.example.passwordmanager.generate_password

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.passwordmanager.R

@Composable
fun GeneratePasswordScreen(
    state: GeneratePasswordState,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = stringResource(R.string.generate_password_screen_password_title))
            Text(text = state.generatedPassword)
            Button(onClick = onClick) {
                Text(text = stringResource(R.string.generate_action))
            }
        }
    }
}