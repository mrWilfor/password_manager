package com.example.core.use_cases

interface GeneratePasswordUseCase {
    suspend operator fun invoke(): String
}