package com.example.mad_auth

import com.intellij.credentialStore.CredentialAttributes
import com.intellij.credentialStore.Credentials
import com.intellij.ide.passwordSafe.PasswordSafe
import com.intellij.ide.plugins.auth.PluginRepositoryAuthProvider
import com.intellij.openapi.diagnostic.Logger


class MadPluginRepositoryAuthProvider : PluginRepositoryAuthProvider {

    private val tokenManager = TokenManager()

    override fun getAuthHeaders(url: String): Map<String, String> {
        return if(url.contains("git.md-dev.ru")) mapOf("PRIVATE-TOKEN" to tokenManager.getToken().toString()) else emptyMap()
    }

    override fun canHandle(url: String): Boolean {
        return true
    }

    companion object {
        val LOG = Logger.getInstance(MadPluginRepositoryAuthProvider::class.java)
    }
}