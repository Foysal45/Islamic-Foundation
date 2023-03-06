package com.islamicfoundation.mbcmlp.presentation.activities.main

import android.os.Bundle
import com.islamicfoundation.mbcmlp.databinding.ActivityMainBinding
import com.islamicfoundation.mbcmlp.presentation.activities.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initializeViewBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    //    setSupportActionBar(binding.toolbar)

    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController, null)
//    }




}