package com.berker.whatsappclone.common

import android.annotation.SuppressLint
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.berker.whatsappclone.R
import com.berker.whatsappclone.ui.model.Message
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView
import java.text.SimpleDateFormat

@BindingAdapter("profilePictureUrl")
fun CircleImageView.setProfilePicture(url: String?) {
    Glide.with(context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.ic_launcher_foreground)
        .into(this)
}

@BindingAdapter("lastMessageText")
fun TextView.setLastMessageText(message: Message?) {
    message?.let {
        this.text = message.content
    }
}

@SuppressLint("SimpleDateFormat")
@BindingAdapter("lastMessageTime")
fun TextView.setLastMessageTime(longTime: Long?) {
    longTime?.let {
        val simpleDateFormat = SimpleDateFormat("HH:mm")
        val dateString = simpleDateFormat.format(longTime)
        this.text = dateString
    }
}