package com.bigstep.videoapp.videoListing

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import butterknife.BindView
import butterknife.ButterKnife
import com.bigstep.videoapp.Injector
import com.bigstep.videoapp.R
import com.bigstep.videoapp.Resource
import com.bigstep.videoapp.model.Result
import com.bigstep.videoapp.videoDetail.VideoDetailActivity
import javax.inject.Inject

class AllVideoListingFragment : Fragment(), VideosListViewHolder.RecyclerViewClickListener {

    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView

    @Inject
    lateinit var viewModelFact: VideosListViewModelFact

    @BindView(R.id.swipeRef)
    lateinit var swipeRef: SwipeRefreshLayout
    private lateinit var videosListingViewModel: VideosListingViewModel
    private val adapter: VideoListingAdapter by lazy {
        VideoListingAdapter(this)
    }

    private var videosList: ArrayList<Result>? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.video_listing_fragment, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity?.applicationContext as Injector).createVideosComponent().inject(this)
        videosListingViewModel =
            ViewModelProvider(this, viewModelFact).get(VideosListingViewModel::class.java)
        initRecyclerView()
        swipeRef.setOnRefreshListener {
            swipeRef.isRefreshing = false
        }
    }

    private fun initRecyclerView() {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
        adapter.setVideosList(videosList)
        adapter.notifyDataSetChanged()
        showVideos()
    }

    private fun showVideos() {
        videosListingViewModel.getVideosList().observe(requireActivity(), Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    videosList = it.data?.results?.toMutableList() as ArrayList<Result>
                    adapter.setVideosList(it.data.results)
                    adapter.notifyDataSetChanged()
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireActivity(), it.message, Toast.LENGTH_SHORT).show()
                }
                Resource.Status.LOADING -> {
                    //   showLoading()
                }
            }
        })

    }

    override fun onRecyclerViewClick(position: Int) {
        videosList?.get(position)?.let {
            videosListingViewModel.updateDataBaseVideos(it)
            val intent = Intent(requireActivity(), VideoDetailActivity::class.java)
            intent.putExtra("videoUrl", it.previewUrl)
            intent.putExtra("songName", it.trackName)
            intent.putExtra("trackArtist", it.artistName)
            intent.putExtra("releaseDate ", it.releaseDate)
            intent.putExtra("thumbNailUrl", it.artworkUrl100)
            startActivity(intent)
        }
    }
}