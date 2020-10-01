package com.bigstep.videoapp.videoListing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class VideosListViewModelFact(private val videoListingRepo: VideoListingRepo) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return VideosListingViewModel(videoListingRepo = videoListingRepo) as T
    }
}