package com.islamicfoundation.mbcmlp.presentation.splash

import android.os.Bundle
import android.text.Html
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {
    val mdots = arrayOfNulls<TextView>(3)
    lateinit var sliderAdapter: SliderAdapter
    private var mCurrentPage = 0
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        this.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN) //for FullScreen View Except appbar or title bar

        sliderAdapter = SliderAdapter(this)
        binding.viewpagerId.adapter = sliderAdapter


        addDotsIndicator(0)
        binding.viewpagerId.addOnPageChangeListener(viewListener)


     /*   if (binding.nextBtn.text=="Let's Go!"){
            binding.nextBtn.setOnClickListener {
                startActivity(Intent(this, AuthActivity::class.java))
                Toast.makeText(this,"clicked!", Toast.LENGTH_LONG).show()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                this.finish()
            }
        }*/



    }
    fun addDotsIndicator(position: Int) {
        binding.dotsLayout.removeAllViews()
        for (i in mdots.indices) {
            mdots[i] = TextView(this)
            mdots[i]!!.text = Html.fromHtml("&#8226")
            mdots[i]!!.textSize = 35f
            mdots[i]!!.setTextColor(resources.getColor(R.color.green))
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
                   // binding.startBtn.visibility = View.GONE
                    binding.nextBtn.text = "Skip"
                    binding.nextBtn.visibility = View.VISIBLE
                    binding.dotsLayout.visibility = View.VISIBLE

                    binding.nextBtn.setOnClickListener {
                       // Toast.makeText(this,"clicked!", Toast.LENGTH_LONG).show()
                        binding.viewpagerId.currentItem = mCurrentPage + 1
                    }
                }
                 1 -> {
                    binding.nextBtn.text = "Skip"
                    binding.nextBtn.visibility = View.VISIBLE
                   // binding.skipBtn.visibility = View.GONE
                    binding.dotsLayout.visibility = View.VISIBLE

                     binding.nextBtn.setOnClickListener {
                         binding.viewpagerId.currentItem = mCurrentPage + 1
                     }
                }
                2 -> {
                    binding.nextBtn.text = "Let's Go!"
                    binding.dotsLayout.visibility = View.VISIBLE
                    binding.nextBtn.visibility = View.VISIBLE

                }
            }

        }


       override fun onPageScrollStateChanged(state: Int) {}
    }

}