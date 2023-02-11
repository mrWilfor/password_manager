package com.example.domain.use_cases

import com.example.core.use_cases.GeneratePasswordUseCase
import com.example.core.PasswordGenerator
import com.example.domain.PasswordGeneratorImpl

class GeneratePasswordUseCaseImpl(
    private val passwordGenerator: PasswordGenerator = PasswordGeneratorImpl()
) : GeneratePasswordUseCase {

    override suspend fun invoke(): String {
        return passwordGenerator.generatePassword()
    }
}