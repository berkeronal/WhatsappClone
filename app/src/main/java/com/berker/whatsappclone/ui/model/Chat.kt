package com.berker.whatsappclone.ui.model

data class Chat(
    val id: Int,
    val photoUrl: String,
    val name: String,
    val messages: List<Message>,
    val chatStatus: ChatStatus
)

data class Message(
    val content: String,
    val sendTime: Long,
    val status: MessageStatus
)

enum class MessageStatus(val value: Int) {
    WAITING(0),
    SEND(1),
    READ(2)
}

enum class ChatStatus(val value: Int) {
    NORMAL(0),
    MUTED(1),
    PINNED(2)
}