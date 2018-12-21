package com.example.dom.ydayssocialcup.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.example.dom.ydayssocialcup.adapter.ParameterAdapter
import com.example.dom.ydayssocialcup.model.ParameterRow

class ParameterFragment : Fragment() {

    private val parameterList: ArrayList<ParameterRow> = ArrayList()
    private lateinit var  recyclerViewUserList : RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        var view = inflater.inflate(R.layout.fragment_parameter, container, false)
        addParameterList()
        recyclerViewUserList = view.findViewById(R.id.recycler_view_fragment_parameter)
        recyclerViewUserList.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewUserList.adapter = ParameterAdapter(parameterList, requireContext())
        return view
    }

    companion object {
        fun newInstance(): ParameterFragment = ParameterFragment()
    }
    fun addParameterList(){
        parameterList.add(ParameterRow("Personnes bloquées",R.drawable.icon_blacklist))
        parameterList.add(ParameterRow("Sécurité",R.drawable.icon_security))
        parameterList.add(ParameterRow("Notification",R.drawable.icon_notification))
    }
}