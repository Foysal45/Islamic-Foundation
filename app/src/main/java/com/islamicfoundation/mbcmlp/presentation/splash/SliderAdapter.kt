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
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.islamicfoundation.mbcmlp.R

class SliderAdapter(mActivity: Activity) : PagerAdapter() {
    var activity = mActivity


    //Array for slider image
    var sliderImage = intArrayOf(
        R.drawable.splash_gif_1,
        R.drawable.splash_gif_2,
        R.drawable.splash_gif_3
    )

    //Array for slider image
    var upperLogo = intArrayOf(
        R.drawable.logo,
        R.drawable.logo,
        R.drawable.logo
    )

    //for upper title
    var headings = arrayOf("Get ", "Get Legal Aid", "Feel ")


    //for description under slider images
    var discription = arrayOf(
        "ইসলামিক ফাউন্ডেশনে আপনাকে স্বাগতম",
        "যেকোনো হালনাগাদের তড়িৎ নোটিফিকেশন পান!",
        "ফাউন্ডেশনের সাথে সংগঠিত থাকুন!")


    override fun getCount(): Int {
        return headings.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as ConstraintLayout
    }

    @NonNull
    override fun instantiateItem(@NonNull container: ViewGroup, position: Int): Any {
        val inflater: LayoutInflater = LayoutInflater.from(activity).context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view: View = inflater.inflate(R.layout.slide_layout, container, false)
        val slideImageView = view.findViewById<View>(R.id.slide_img) as ImageView
        //val upperLogo = view.findViewById<View>(R.id.upper_logo) as ImageView
        //val slideHeading = view.findViewById<View>(R.id.slide_heading) as TextView
        val slideDescription = view.findViewById<View>(R.id.slide_description) as TextView
        slideImageView.setImageResource(sliderImage[position])
        // upperLogo.setImageResource(upperLogo[position])
        //slideHeading.text = headings[position]
        slideDescription.text = discription[position]
        container.addView(view)
        return view
    }

    @NonNull
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }

}