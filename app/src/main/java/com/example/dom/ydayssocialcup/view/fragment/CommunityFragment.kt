package com.example.dom.ydayssocialcup.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.example.dom.ydayssocialcup.adapter.MessageCommunityAdapter
import com.example.dom.ydayssocialcup.model.MessageCommunity
import com.example.dom.ydayssocialcup.model.UserList

class CommunityFragment : Fragment() {

    private val messageList: ArrayList<MessageCommunity> = ArrayList()
    private lateinit var  recyclerViewUserList : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        var view = inflater.inflate(R.layout.fragment_community, container, false)

        addMessageCommunityList()
        recyclerViewUserList = view.findViewById(R.id.recycler_view_fragment_community)
        recyclerViewUserList.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewUserList.adapter = MessageCommunityAdapter(messageList, requireContext())
        return view
    }



    companion object {
        fun newInstance(): CommunityFragment = CommunityFragment()
    }

    fun addMessageCommunityList(){
        messageList.add(MessageCommunity("Test 1 ",R.drawable.card_profil))
        messageList.add(MessageCommunity("Test 2",R.drawable.card_profil))


    }
}