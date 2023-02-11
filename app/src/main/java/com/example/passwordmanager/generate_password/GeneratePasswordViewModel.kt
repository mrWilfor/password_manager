package com.example.passwordmanager.generate_password

import androidx.lifecycle.viewModelScope
import com.example.core.use_cases.GeneratePasswordUseCase
import com.example.core_android.BaseViewModel
import com.example.domain.use_cases.GeneratePasswordUseCaseImpl
import kotlinx.coroutines.launch

class GeneratePasswordViewModel(
    private val generatePasswordUseCase: GeneratePasswordUseCase = GeneratePasswordUseCaseImpl()
) : BaseViewModel<GeneratePasswordState, GeneratePasswordEvent, GeneratePasswordEffect>() {
    override fun initialState() = GeneratePasswordState()

    override fun sendEvent(event: GeneratePasswordEvent) {
        when (event) {
            is GeneratePasswordEvent.Generate -> reduceGenerate()
        }
    }

    private fun reduceGenerate() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                generatedPassword = generatePasswordUseCase.invoke()
            )
        }
    }
}