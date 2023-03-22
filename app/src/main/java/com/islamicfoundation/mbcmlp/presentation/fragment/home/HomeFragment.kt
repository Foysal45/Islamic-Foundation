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
import kotlin.collections.ArrayList


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentHomeBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        barChartForLastSevenDaysVisitEducationCentre()

        barChartForLastSevenDaysVisitResourceCentre()



    }

    private fun barChartForLastSevenDaysVisitEducationCentre(){

        binding?.barChartLastSevenDaysVisitEducationCentre?.setDrawBarShadow(false)
        binding?.barChartLastSevenDaysVisitEducationCentre?.setDrawValueAboveBar(true)
        binding?.barChartLastSevenDaysVisitEducationCentre?.setMaxVisibleValueCount(50)
        binding?.barChartLastSevenDaysVisitEducationCentre?.setPinchZoom(false)
        binding?.barChartLastSevenDaysVisitEducationCentre?.setDrawGridBackground(true)
        binding?.barChartLastSevenDaysVisitEducationCentre?.description?.isEnabled = false
        binding?.barChartLastSevenDaysVisitEducationCentre?.animateY(2000)

        val xAxis = binding?.barChartLastSevenDaysVisitEducationCentre?.xAxis
        xAxis?.position = XAxis.XAxisPosition.BOTTOM
        xAxis?.setDrawGridLines(false)
        xAxis?.granularity = 1f
        xAxis?.labelCount = 5

        val leftAxis = binding?.barChartLastSevenDaysVisitEducationCentre?.axisLeft
        leftAxis?.setDrawGridLines(true)
        leftAxis?.spaceTop = 30f
        leftAxis?.axisMinimum = 0f

        val rightAxis = binding?.barChartLastSevenDaysVisitEducationCentre?.axisRight
        rightAxis?.isEnabled = false

        val entries: MutableList<BarEntry> = ArrayList()
        entries.add(BarEntry(1f, 1f))
        entries.add(BarEntry(2f, 2f))
        entries.add(BarEntry(3f, 3f))
        entries.add(BarEntry(4f, 4f))
        entries.add(BarEntry(5f, 5f))
        entries.add(BarEntry(6f, 6f))
        entries.add(BarEntry(7f, 7f))

        val dataSet = BarDataSet(entries, "গত সাত দিনে পরিদর্শিত শিক্ষা কেন্দ্র")
        dataSet.setColors(*ColorTemplate.COLORFUL_COLORS)
        dataSet.setDrawValues(true)
        dataSet.valueTextColor = Color.DKGRAY
        dataSet.valueTextSize = 10f

        val data = BarData(dataSet)
        binding?.barChartLastSevenDaysVisitEducationCentre?.data = data
        binding?.barChartLastSevenDaysVisitEducationCentre?.invalidate()
    }


    private fun barChartForLastSevenDaysVisitResourceCentre(){

        binding?.barChartLastSevenDaysVisitResourceCentre?.setDrawBarShadow(true)
        binding?.barChartLastSevenDaysVisitResourceCentre?.setDrawValueAboveBar(true)
        binding?.barChartLastSevenDaysVisitResourceCentre?.setMaxVisibleValueCount(50)
        binding?.barChartLastSevenDaysVisitResourceCentre?.setPinchZoom(false)
        binding?.barChartLastSevenDaysVisitResourceCentre?.setDrawGridBackground(true)
        binding?.barChartLastSevenDaysVisitResourceCentre?.description?.isEnabled = false
        binding?.barChartLastSevenDaysVisitResourceCentre?.animateY(2000)
        binding?.barChartLastSevenDaysVisitResourceCentre?.notifyDataSetChanged()

        val xAxis = binding?.barChartLastSevenDaysVisitResourceCentre?.xAxis
        xAxis?.position = XAxis.XAxisPosition.BOTTOM
        xAxis?.setDrawGridLines(false)
        xAxis?.granularity = 1f
        xAxis?.labelCount = 5

        val leftAxis = binding?.barChartLastSevenDaysVisitResourceCentre?.axisLeft
        leftAxis?.setDrawGridLines(false)
        leftAxis?.setDrawGridLines(false)
        leftAxis?.isEnabled = false
        //leftAxis?.spaceTop = 0f
        //leftAxis?.axisMinimum = 0f

      /*  leftAxis?.valueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                // You can return any text you want here based on the value
                return "okey"
            }
        }
*/
        val rightAxis = binding?.barChartLastSevenDaysVisitResourceCentre?.axisRight
        rightAxis?.isEnabled = false

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
        dataSet.valueTextSize = 12f


        val data = BarData(dataSet)
        binding?.barChartLastSevenDaysVisitResourceCentre?.data = data
        binding?.barChartLastSevenDaysVisitResourceCentre?.invalidate()


    }


    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}