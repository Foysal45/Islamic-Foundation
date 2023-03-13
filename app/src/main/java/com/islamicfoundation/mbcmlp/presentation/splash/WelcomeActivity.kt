package com.islamicfoundation.mbcmlp.presentation.splash

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.databinding.ActivityWelcomeBinding
import com.islamicfoundation.mbcmlp.presentation.activities.auth.AuthActivity

class WelcomeActivity : AppCompatActivity() {
    val mdots = arrayOfNulls<TextView>(3)
    lateinit var sliderAdapter: SliderAdapter
    private var mCurrentPage = 0
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_welcome)
        this.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN) //for FullScreen View Except appbar or title bar



        sliderAdapter = SliderAdapter(this)
        binding.viewpagerId.adapter = sliderAdapter


        addDotsIndicator(0)
        binding.viewpagerId.addOnPageChangeListener(viewListener)

        binding.nextBtn.setOnClickListener {
            binding.viewpagerId.currentItem = mCurrentPage + 1
        }

        binding.skipBtn.setOnClickListener{
            startActivity(Intent(this, AuthActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            this.finish()
        }

        binding.startBtn.setOnClickListener{
            startActivity(Intent(this, AuthActivity::class.java))
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            this.finish()
        }


    }

    fun addDotsIndicator(position: Int) {
        binding.dotsLayout.removeAllViews()
        for (i in mdots.indices) {
            mdots[i] = TextView(this)
            mdots[i]!!.text = Html.fromHtml("&#8226")
            mdots[i]!!.textSize = 35f
            mdots[i]!!.setTextColor(resources.getColor(R.color.colorBlack))
            binding.dotsLayout.addView(mdots[i])
        }
        if (mdots.isNotEmpty()) mdots[position]!!.setTextColor(resources.getColor(R.color.colorWhite))
    }



    var viewListener: ViewPager.OnPageChangeListener = object : ViewPager.OnPageChangeListener {

        override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
        override fun onPageSelected(position: Int) {
            addDotsIndicator(position)
            mCurrentPage = position
            when (position) {
                0 -> {
                    binding.startBtn.visibility = View.GONE
                    binding.nextBtn.visibility = View.VISIBLE
                    binding.skipBtn.visibility = View.VISIBLE
                    binding.dotsLayout.visibility = View.VISIBLE
                }
                mdots.size - 1 -> {
                    binding.startBtn.visibility = View.VISIBLE
                    binding.nextBtn.visibility = View.GONE
                    binding.skipBtn.visibility = View.GONE
                    binding.dotsLayout.visibility = View.GONE
                }
                else -> {
                    binding.nextBtn.text = "Next"
                    binding.startBtn.visibility = View.GONE
                    binding.dotsLayout.visibility = View.VISIBLE
                    binding.nextBtn.visibility = View.VISIBLE
                    binding.skipBtn.visibility = View.VISIBLE
                }
            }
        }

       override fun onPageScrollStateChanged(state: Int) {}
    }

}