package com.example.dom.ydayssocialcup.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.example.dom.ydayssocialcup.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.fragment_advice.*
import kotlinx.android.synthetic.main.fragment_advice.view.*

class AdviceFragment : Fragment() {

    private lateinit var viewPager : ViewPager

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment_advice, container, false)
        val fragmentAdapter = MyPagerAdapter(childFragmentManager)
        viewPager = view.viewpager_main
        viewPager.adapter = fragmentAdapter

        view.tabs_main.setupWithViewPager(viewPager)
        return view
    }




    companion object {
        fun newInstance(): AdviceFragment = AdviceFragment()
    }
}