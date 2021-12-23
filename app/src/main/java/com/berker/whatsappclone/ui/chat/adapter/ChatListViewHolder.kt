package com.berker.whatsappclone.ui.chat.adapter

import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.RecyclerView
import com.berker.whatsappclone.databinding.ItemRvChatListBinding
import com.berker.whatsappclone.ui.model.Chat

class ChatListViewHolder(
    private val itemBinding: ItemRvChatListBinding,
    private val clickedItem: ((chat: Chat, binding: ItemRvChatListBinding) -> Unit)?,
    private val imageClick: ((Chat) -> Unit)?
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(chat: Chat) {
        with(itemBinding) {
            civProfileImage.setOnClickListener {
                imageClick?.invoke(chat)
            }
        ViewCompat.setTransitionName(civProfileImage,"chat_iv_${chat.id}")

        }
    }
}