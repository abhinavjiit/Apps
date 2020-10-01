package com.bigstep.videoapp

import com.bigstep.videoapp.model.VideoListingResponse
import retrofit2.http.GET

interface NetworkApiCall {

    @GET("search?term=Michael+jackson&media=musicVideo")
    suspend fun getAllVideosList(): VideoListingResponse

}