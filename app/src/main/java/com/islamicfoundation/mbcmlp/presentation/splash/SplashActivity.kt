package com.islamicfoundation.mbcmlp.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.presentation.activities.auth.AuthActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        this.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN) //for FullScreen View Except appbar or title bar
        //background_circle.animate().setDuration(5000).setStartDelay(100).scaleY(8f).scaleX(8f).start()

        Handler().postDelayed(
            {
                startActivity(Intent(this, WelcomeActivity::class.java))
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                this.finish()
            }, 3100
        )
    }
}