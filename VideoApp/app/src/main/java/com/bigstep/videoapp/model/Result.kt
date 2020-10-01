package com.bigstep.videoapp.model


import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Videos_list")
data class Result(

    @SerializedName("artistName")
    var artistName: String? = null,


    @SerializedName("artworkUrl100")
    var artworkUrl100: String? = null,


    @SerializedName("previewUrl")
    var previewUrl: String,


    @SerializedName("releaseDate")
    var releaseDate: String? = null,


    @SerializedName("trackName")
    var trackName: String? = null,


    @PrimaryKey
    @SerializedName("trackId")
    var trackId: String,

    @SerializedName("trackNumber")
    var trackNumber: Int? = null,

    @SerializedName("trackPrice")
    var trackPrice: Double? = null,


    @SerializedName("trackViewUrl")
    var trackViewUrl: String? = null


)


