package com.example.dom.ydayssocialcup.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R

class CampaignFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_campaign, container, false)

    companion object {
        fun newInstance(): CampaignFragment = CampaignFragment()
    }
}