package com.example.dom.ydayssocialcup.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.dom.ydayssocialcup.view.fragment.HarassmentTabFragment
import com.example.dom.ydayssocialcup.view.fragment.VictimTabFragment
import com.example.dom.ydayssocialcup.view.fragment.WitnessesTabFragment

class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HarassmentTabFragment()
            }
            1 -> VictimTabFragment()
            else -> {
                return WitnessesTabFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> {
                return "Third Tab"
            }
        }
    }
}