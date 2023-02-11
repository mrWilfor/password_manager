package com.example.domain

import com.example.core.utils.GlobalConstants.emptyString
import com.example.core.PasswordGenerator

class PasswordGeneratorImpl : PasswordGenerator {
    private val chars = 'a'..'z'
    private val upperChars = 'A'..'Z'
    private val numbers = '0'..'9'
    private val specSymbol =
        arrayOf('@', ';', '$', '%', '&', '/', '!', '”', '#', '*', '_', '<', '>')

    lateinit var password: CharArray

    override fun generatePassword(
        lengthPassword: Int,
        numberOfUppercaseChars: Int,
        numbersOfNumbers: Int,
        numbersOfSpecSymbols: Int
    ): String {
        password = CharArray(lengthPassword)
        var arrayItemCount = lengthPassword

        repeat(numberOfUppercaseChars) {
            if (arrayItemCount < 0) return@repeat
            password[--arrayItemCount] = upperChars.random()
        }
        repeat(numbersOfNumbers) {
            if (arrayItemCount < 0) return@repeat
            password[--arrayItemCount] = numbers.random()
        }
        repeat(numbersOfSpecSymbols) {
            if (arrayItemCount < 0) return@repeat
            password[--arrayItemCount] = specSymbol.random()
        }

        repeat(arrayItemCount) {
            if (arrayItemCount < 0) return@repeat

            password[--arrayItemCount] = chars.random()
        }

        return password
            .also(CharArray::shuffle)
            .joinToString(separator = emptyString)
    }
}