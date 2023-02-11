package com.example.passwordmanager.generate_password

import com.example.core.utils.GlobalConstants.emptyString

data class GeneratePasswordState(
    val generatedPassword: String = emptyString
)

sealed class GeneratePasswordEvent {
    object Generate: GeneratePasswordEvent()
}

sealed class GeneratePasswordEffect {
    object Success: GeneratePasswordEffect()
    object Failure: GeneratePasswordEffect()
}