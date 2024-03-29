package com.example.core

interface PasswordGenerator {
    fun generatePassword(
        lengthPassword: Int = 8,
        numberOfUppercaseChars: Int = 1,
        numbersOfNumbers: Int = 1,
        numbersOfSpecSymbols: Int = 1
    ): String
}