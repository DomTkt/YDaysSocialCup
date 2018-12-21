package com.example.dom.ydayssocialcup.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.example.dom.ydayssocialcup.adapter.UserListAdapter
import com.example.dom.ydayssocialcup.interfaces.OnItemAdapterClickListener
import com.example.dom.ydayssocialcup.model.UserList

class UserFragment : Fragment(), OnItemAdapterClickListener {

    override fun onItemAdapterClick(position: Int) {

        if(position == 1){

        }


    }

    private val userList: ArrayList<UserList> = ArrayList()
    private lateinit var  recyclerViewUserList : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view =  inflater.inflate(R.layout.fragment_user, container, false)

        addUserList()
        recyclerViewUserList = view.findViewById(R.id.fragment_user_recycler_view)
        recyclerViewUserList.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewUserList.adapter = UserListAdapter(userList, requireContext(),this)

        return view
    }

    companion object {
        fun newInstance(): UserFragment = UserFragment()
    }

    fun addUserList() {
        userList.add(UserList(getString(R.string.user_fragment_label_parameter),R.drawable.navigation_icon_map))
        userList.add(UserList(getString(R.string.user_fragment_label_statistics),R.drawable.navigation_icon_statistic))
        userList.add(UserList(getString(R.string.user_fragment_label_conseil),R.drawable.navigation_icon_conseil))
        userList.add(UserList(getString(R.string.user_fragment_label_help),R.drawable.navigation_icon_help))
        userList.add(UserList(getString(R.string.user_fragment_label_a_propos),R.drawable.navigation_icon_a_propos))
    }

}