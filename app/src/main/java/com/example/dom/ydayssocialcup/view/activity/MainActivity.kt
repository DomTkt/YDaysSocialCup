package com.example.dom.ydayssocialcup.view.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import com.crashlytics.android.Crashlytics
import com.example.dom.ydayssocialcup.R
import com.example.dom.ydayssocialcup.view.fragment.*
import io.fabric.sdk.android.Fabric
import kotlinx.android.synthetic.main.nav_header.*


class MainActivity : AppCompatActivity(){

    private lateinit var mDrawerLayout: DrawerLayout
    private lateinit var imageView : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Fabric.with(this, Crashlytics())

//        val bottomNavigation: BottomNavigationView = findViewById(R.id.navigationView)
//        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        mDrawerLayout = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            mDrawerLayout.closeDrawers()

            true

        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.mipmap.icon_navigation_menu)
        }

        mDrawerLayout.addDrawerListener(
            object : DrawerLayout.DrawerListener {
                override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                    // Respond when the drawer's position changes
                }

                override fun onDrawerOpened(drawerView: View) {
                    // Respond when the drawer is opened
                }

                override fun onDrawerClosed(drawerView: View) {
                    // Respond when the drawer is closed
                }

                override fun onDrawerStateChanged(newState: Int) {
                    // Respond when the drawer motion state changes
                }
            }
        )

        setupDrawerContent(navigationView)


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }

    fun selectDrawerItem(menuItem: MenuItem) {
        // Create a new fragment and specify the fragment to show based on nav item clicked
        var fragment: Fragment? = null
        val fragmentClass: Class<*>
        when (menuItem.itemId) {
            R.id.nav_map -> fragmentClass = MapFragment::class.java
            R.id.nav_statistics -> fragmentClass = StatisticsFragment::class.java
            R.id.nav_community -> fragmentClass = CommunityFragment::class.java
            R.id.nav_campagnes -> fragmentClass = CampaignFragment::class.java
            R.id.nav_help -> fragmentClass = HarassmentHelpFragment::class.java
            R.id.nav_a_propos -> fragmentClass = AboutFragment::class.java
            R.id.nav_parameter -> fragmentClass = ParameterFragment::class.java
            R.id.nav_conseils -> fragmentClass = AdviceFragment::class.java
            R.id.nav_myaccount -> fragmentClass = MyAccountFragment::class.java
            else -> fragmentClass = AboutFragment::class.java
        }

        try {
            fragment = fragmentClass.newInstance() as Fragment
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Insert the fragment by replacing any existing fragment
        val fragmentManager = supportFragmentManager
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit()

        // Highlight the selected item has been done by NavigationView
        menuItem.isChecked = true
        // Set action bar title
        title = menuItem.title
        // Close the navigation drawer
        mDrawerLayout.closeDrawers()
    }

}
