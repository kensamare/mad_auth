package com.example.mad_auth

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages

class SaveTokenAction : AnAction("Mad Auth") {

    override fun actionPerformed(event: AnActionEvent) {
        // Вызов диалога для ввода токена
        val token = Messages.showInputDialog(
            event.project,
            "Please enter your Gitlab token:",
            "Set Gitlab Token",
            Messages.getQuestionIcon()
        )

        if (!token.isNullOrEmpty()) {
            val tokenManager = TokenManager()
            tokenManager.saveToken(token)
            Messages.showInfoMessage(event.project, "Token saved successfully!", "Success")
        } else {
            Messages.showErrorDialog(event.project, "Token cannot be empty.", "Error")
        }
    }
}
