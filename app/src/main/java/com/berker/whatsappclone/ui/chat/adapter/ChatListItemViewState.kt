package com.berker.whatsappclone.ui.chat.adapter

import com.berker.whatsappclone.ui.model.Chat

data class ChatListItemViewState(
    private val chat: Chat
) {
    fun getProfilePicture() = chat.photoUrl
    fun getName() = chat.name
    fun getLastMessage() = chat.messages.last()
    fun getLastMessageTime() = chat.messages.last().sendTime
    fun getChatStatus() = chat.chatStatus
}