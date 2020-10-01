package com.bigstep.videoapp.videoDetail

import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import com.bigstep.videoapp.R
import com.google.android.exoplayer2.*
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.squareup.picasso.Picasso


const val STREAM_URL =
    "https://video-ssl.itunes.apple.com/itunes-assets/Video125/v4/de/9e/61/de9e6127-057d-fb72-99c7-9e28a8ab8b96/mzvf_6859672216512745312.640x464.h264lc.U.p.m4v"

class VideoDetailActivity : AppCompatActivity() {
    @BindView(R.id.exoPlayer)
    lateinit var playerView: PlayerView
    private lateinit var exoPlayer: ExoPlayer

    @BindView(R.id.artistName)
    lateinit var artistName: TextView

    @BindView(R.id.trackName)
    lateinit var trackName: TextView

    @BindView(R.id.artistImageView)
    lateinit var artistImageView: ImageView

    private var streamUrl: String? = null
    private var releaseDate: String? = null
    private var trackArtist: String? = null
    private var songName: String? = null
    private var thumbNailUrl: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        streamUrl = intent?.getStringExtra("videoUrl")
        releaseDate = intent?.getStringExtra("releaseDate")
        trackArtist = intent?.getStringExtra("trackArtist")
        songName = intent?.getStringExtra("songName")
        thumbNailUrl = intent.getStringExtra("thumbNailUrl")

        artistName.text = "Artist : ".plus(trackArtist)
        trackName.text = "Song : ".plus(songName)
        Picasso.get().load(thumbNailUrl).into(artistImageView)
        val loadControl = DefaultLoadControl()
        val renderersFactory = DefaultRenderersFactory(this)
        val track = DefaultTrackSelector()
        exoPlayer = ExoPlayerFactory.newSimpleInstance(
            this,
            renderersFactory, track, loadControl
        )
        val mediaSource = ExtractorMediaSource
            .Factory(DefaultDataSourceFactory(this, "userAgent"))
            .setExtractorsFactory(DefaultExtractorsFactory())
            .createMediaSource(Uri.parse(streamUrl))
        playerView.player = exoPlayer
        exoPlayer.prepare(mediaSource)
        exoPlayer.playWhenReady = true


    }


    override fun onPause() {
        super.onPause()
        exoPlayer.playWhenReady = false

    }

    override fun onRestart() {
        super.onRestart()
        if (!exoPlayer.playWhenReady && exoPlayer.playbackState == Player.STATE_ENDED)
            exoPlayer.playWhenReady = true
    }


    override fun onStop() {
        super.onStop()
        if (exoPlayer.playWhenReady && exoPlayer.playbackState == Player.STATE_READY)
            exoPlayer.release()

    }

    override fun onDestroy() {
        super.onDestroy()
        if (exoPlayer.playWhenReady && exoPlayer.playbackState == Player.STATE_READY)
            exoPlayer.release()
    }

}