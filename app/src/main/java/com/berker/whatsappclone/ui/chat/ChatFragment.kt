package com.berker.whatsappclone.ui.chat

import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.berker.whatsappclone.R
import com.berker.whatsappclone.databinding.FragmentChatBinding
import com.berker.whatsappclone.ui.base.BaseFragment
import com.berker.whatsappclone.ui.chat.adapter.ChatListAdapter


class ChatFragment : BaseFragment<FragmentChatBinding>() {

    private val chatListAdapter:ChatListAdapter by lazy {
        ChatListAdapter().apply {
            stateRestorationPolicy = RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val transition =
            TransitionInflater.from(context).inflateTransition(R.transition.move_custom)
        transition.duration = 600L
        sharedElementEnterTransition = transition
    }


    override fun layoutId(): Int = R.layout.fragment_chat

    override fun initUi() {

    }
}