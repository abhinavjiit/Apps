package com.bigstep.videoapp.model


import com.google.gson.annotations.SerializedName

data class VideoListingResponse(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Result>
)