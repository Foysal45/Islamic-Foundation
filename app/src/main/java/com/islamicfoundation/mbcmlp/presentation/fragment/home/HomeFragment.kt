package com.islamicfoundation.mbcmlp.presentation.fragment.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate
import com.islamicfoundation.mbcmlp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentHomeBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        barChart()

        val entries: MutableList<BarEntry> = ArrayList()
        entries.add(BarEntry(1f, 1f))
        entries.add(BarEntry(2f, 2f))
        entries.add(BarEntry(3f, 3f))
        entries.add(BarEntry(4f, 4f))
        entries.add(BarEntry(5f, 5f))
        entries.add(BarEntry(6f, 6f))
        entries.add(BarEntry(7f, 7f))

        val dataSet = BarDataSet(entries, "My Bar Chart")
        dataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        dataSet.setDrawValues(true)
        dataSet.valueTextColor = Color.DKGRAY
        dataSet.valueTextSize = 10f

        val data = BarData(dataSet)
        binding?.barChart?.setData(data)
        binding?.barChart?.invalidate();

    }

    fun barChart(){

        binding?.barChart?.setDrawBarShadow(false)
        binding?.barChart?.setDrawValueAboveBar(true)
        binding?.barChart?.setMaxVisibleValueCount(50)
        binding?.barChart?.setPinchZoom(false)
        binding?.barChart?.setDrawGridBackground(true)

        val xAxis = binding?.barChart?.xAxis
        xAxis?.position = XAxis.XAxisPosition.BOTTOM
        xAxis?.setDrawGridLines(false)
        xAxis?.granularity = 1f
        xAxis?.labelCount = 5

        val leftAxis = binding?.barChart?.axisLeft
        leftAxis?.setDrawGridLines(true)
        leftAxis?.spaceTop = 30f
        leftAxis?.axisMinimum = 0f

        val rightAxis = binding?.barChart?.axisRight
        rightAxis?.isEnabled = false
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}