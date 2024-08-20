package com.example.mad_auth

import com.intellij.ide.passwordSafe.PasswordSafe

import com.intellij.credentialStore.CredentialAttributes


class TokenManager {

    private val serviceName = "com.example.mad_auth.token"

    // Метод для сохранения токена
    fun saveToken(token: String) {
        val attributes = CredentialAttributes(serviceName)
        PasswordSafe.instance.setPassword(attributes, token)
    }

    // Метод для получения токена
    fun getToken(): String? {
        val attributes = CredentialAttributes(serviceName)
        return PasswordSafe.instance.getPassword(attributes)
    }

    // Метод для удаления токена
    fun deleteToken() {
        val attributes = CredentialAttributes(serviceName)
        PasswordSafe.instance.setPassword(attributes, null)
    }
}

