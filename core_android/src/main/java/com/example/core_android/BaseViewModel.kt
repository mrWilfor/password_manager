package com.example.core_android

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<STATE, EVENT, EFFECT>: ViewModel() {
    private val _state = MutableStateFlow(this.initialState())
    val state: StateFlow<STATE> = _state

    private val _effect = MutableSharedFlow<EFFECT>()
    val effect: SharedFlow<EFFECT> = _effect

    abstract fun initialState(): STATE
    abstract fun sendEvent(event: EVENT)
}