package com.berker.whatsappclone.ui.chat.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berker.whatsappclone.databinding.ItemRvChatListBinding
import com.berker.whatsappclone.ui.model.Chat

class ChatListAdapter(
    var itemClickListener: ((chat: Chat, binding: ItemRvChatListBinding) -> Unit)? = null,
    var imageClick: ((Chat) -> Unit)? = null
) : RecyclerView.Adapter<ChatListViewHolder>() {

    private var itemList: List<Chat> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatListViewHolder {
        val itemBinding =
            ItemRvChatListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ChatListViewHolder(itemBinding, itemClickListener, imageClick)
    }

    override fun onBindViewHolder(holder: ChatListViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun updateData(newChatList: List<Chat>) {
        itemList = newChatList
        notifyDataSetChanged()
    }

    fun getItem(position: Int): Chat = itemList[position]
}