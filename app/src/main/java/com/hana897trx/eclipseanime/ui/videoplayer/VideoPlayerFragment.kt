package com.hana897trx.eclipseanime.ui.videoplayer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hana897trx.eclipseanime.databinding.FragmentVideoPlayerBinding
import com.hana897trx.eclipseanime.utilities.DataUtils.ANIME_VIDEO_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoPlayerFragment : Fragment() {

    private lateinit var binding : FragmentVideoPlayerBinding
    private var videoURL : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            videoURL = it.getString(ANIME_VIDEO_URL) ?: ""
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentVideoPlayerBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setView()
    }

    private fun setView() = binding.apply {
        animeVideoPlayer.setVideoPath(videoURL)
        animeVideoPlayer.start()
    }
}