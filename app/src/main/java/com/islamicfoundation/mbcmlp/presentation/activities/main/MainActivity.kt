package com.islamicfoundation.mbcmlp.presentation.activities.main

import DrawerListItem
import android.os.Bundle
import android.view.MenuItem
import android.widget.ExpandableListView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.islamicfoundation.mbcmlp.R
import com.islamicfoundation.mbcmlp.activity.toast
import com.islamicfoundation.mbcmlp.databinding.ActivityMainBinding
import com.islamicfoundation.mbcmlp.presentation.activities.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initializeViewBinding() = ActivityMainBinding.inflate(layoutInflater)
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var navigationMenuId: Int = 0
    private var menuItem: MenuItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.appBarMain.customToolBar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        appBarConfiguration = AppBarConfiguration(setOf(R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Set up expandable ListView
       // val listView = findViewById<ExpandableListView>(R.id.nav_expandable_list)
        val drawerItems = listOf(
            DrawerListItem(listOf("Item 1", "Item 2", "Item 3")),
            //DrawerListItem(listOf("Item 4", "Item 5", "Item 6")),
           // DrawerListItem(listOf("Item 7", "Item 8", "Item 9"))
        )

     navView.setNavigationItemSelectedListener { item ->
         navigationMenuId = item.itemId
         menuItem = item
         when (menuItem!!.itemId) {
            R.id.nav_visit -> {
                Toast.makeText(this, "clicked",Toast.LENGTH_SHORT ).show()
                val adapter = ExpandableListAdapter(this, drawerItems)
                //listView.setAdapter(adapter)
             }
         }
         true
        }

    }




    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}