package com.example.dom.ydayssocialcup.view.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.dom.ydayssocialcup.R
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate


class StatisticsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View?{
        val view = inflater.inflate(R.layout.fragment_statistics, container, false)
        val barChart = view.findViewById(R.id.barchart) as BarChart
        val labels = ArrayList<String>()
        labels.add("2016")
        labels.add("2015")
        labels.add("2014")
        labels.add("2013")
        labels.add("2012")

        val entries = java.util.ArrayList<BarEntry>()
        entries.add(BarEntry(8f, 0f))
        entries.add(BarEntry(2f, 1f))
        entries.add(BarEntry(5f, 2f))
        entries.add(BarEntry(20f, 3f))
        entries.add(BarEntry(15f, 4f))
        entries.add(BarEntry(19f, 5f))

        val bardataset = BarDataSet(entries, "Cells")
        barChart.animateY(5000)

        val data = BarData(bardataset)
        bardataset.setColors(*ColorTemplate.COLORFUL_COLORS)
        barChart.data = data


        return view
    }

    companion object {
        fun newInstance(): StatisticsFragment = StatisticsFragment()
    }
}