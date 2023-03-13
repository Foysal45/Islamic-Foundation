package com.islamicfoundation.mbcmlp.presentation.splash

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.viewpager.widget.PagerAdapter
import com.islamicfoundation.mbcmlp.R

class SliderAdapter(mActivity: Activity) : PagerAdapter() {
    var activity = mActivity


    //Array
    var sliderImage = intArrayOf(
        R.drawable.login,
        R.drawable.logo,
        R.drawable.logo
    )
    var headings = arrayOf(
        "Get Everything You Want",
        "Get Legal Aid",
        "Feel the Joy In You"
    )

    var discription = arrayOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut",
        "")


    override fun getCount(): Int {
        return headings.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as RelativeLayout
    }

    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {
        val inflater: LayoutInflater = LayoutInflater.from(activity).context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.slide_layout, container, false)
        val slideImageView = view.findViewById<View>(R.id.slide_img) as ImageView
        val slideHeading = view.findViewById<View>(R.id.slide_heading) as TextView
        val slideDescription = view.findViewById<View>(R.id.slide_description) as TextView
        slideImageView.setImageResource(sliderImage[position])
        slideHeading.text = headings[position]
        slideDescription.text = discription[position]
        container.addView(view)
        return view
    }

    @NonNull
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }

}