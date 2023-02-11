package com.example.passwordmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.passwordmanager.generate_password.GeneratePasswordEvent
import com.example.passwordmanager.generate_password.GeneratePasswordScreen
import com.example.passwordmanager.generate_password.GeneratePasswordViewModel
import com.example.passwordmanager.ui.theme.PasswordManagerTheme

class MainActivity : ComponentActivity() {
    private val viewModel: GeneratePasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordManagerTheme(
                darkTheme = true
            ) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val state = viewModel.state.collectAsState(lifecycleScope.coroutineContext)

                    GeneratePasswordScreen(
                        state = state.value,
                        onClick = {
                            viewModel.sendEvent(GeneratePasswordEvent.Generate)
                        }
                    )
                }
            }
        }
    }
}
