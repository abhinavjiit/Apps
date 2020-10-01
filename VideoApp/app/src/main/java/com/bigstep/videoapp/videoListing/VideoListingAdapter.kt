package com.bigstep.videoapp.videoListing

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bigstep.videoapp.R
import com.bigstep.videoapp.model.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_item_list_adapter_layout.view.*

class VideoListingAdapter(val recyclerViewClickListener: VideosListViewHolder.RecyclerViewClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var videosList: List<Result>? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.video_item_list_adapter_layout, parent, false)
        return VideosListViewHolder(view, recyclerViewClickListener)
    }

    fun setVideosList(videosList: List<Result>?) {
        this.videosList = videosList
    }

    override fun getItemCount(): Int {
        return videosList?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is VideosListViewHolder) {
            videosList?.get(position)?.let {
                holder.onBind(it)
            }
        }
    }
}


class VideosListViewHolder(
    view: View,
    private val recyclerViewClickListener: RecyclerViewClickListener
) : RecyclerView.ViewHolder(view), View.OnClickListener {

    private val imageView: ImageView = view.imageView
    private val videoName: TextView = view.videoName
    private val cardView: CardView = view.cardView

    init {
        cardView.setOnClickListener(this)
    }

    fun onBind(data: Result) {
        Picasso.get().load(data.artworkUrl100).into(imageView)
        videoName.text = data.trackName
    }

    override fun onClick(view: View?) {
        recyclerViewClickListener.onRecyclerViewClick(adapterPosition)
    }

    interface RecyclerViewClickListener {
        fun onRecyclerViewClick(position: Int)
    }

}
