package com.bigstep.videoapp.videoListing

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import butterknife.BindView
import butterknife.ButterKnife
import com.bigstep.videoapp.R
import com.google.android.material.tabs.TabLayout

class VideoListingActivity : AppCompatActivity() {

    @BindView(R.id.tabs)
    lateinit var tabs: TabLayout

    @BindView(R.id.viewPager)
    lateinit var viewPager: ViewPager

    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar

    @BindView(R.id.back)
    lateinit var back: TextView

    private val videoPagerAdapter: VideoPagerAdapter by lazy {
        VideoPagerAdapter(supportFragmentManager)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_listing_activity)
        ButterKnife.bind(this)
        tabs.apply {
            addTab(tabs.newTab().setText("AllVideos"))
            addTab(tabs.newTab().setText("SelectedVideos"))
        }
        viewPager.adapter = videoPagerAdapter
        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabs))
        tabs.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab?.position!!
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab?.position!!

            }
        })

        back.setOnClickListener {
            finish()
        }
    }
}