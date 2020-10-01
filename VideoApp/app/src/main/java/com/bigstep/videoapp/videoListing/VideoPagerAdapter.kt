package com.bigstep.videoapp.videoListing

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class VideoPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(
    fm,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT
) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            1 -> {
                PreviouslySelectedVideosFragment()
            }

            else -> {
                AllVideoListingFragment()

            }
        }
    }

    override fun getCount(): Int {
        return 2
    }
}