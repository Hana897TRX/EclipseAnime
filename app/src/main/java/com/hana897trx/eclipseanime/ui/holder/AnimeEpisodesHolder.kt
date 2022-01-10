package com.hana897trx.eclipseanime.ui.holder

import android.annotation.SuppressLint
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.data.models.EpisodeDataModel
import com.hana897trx.eclipseanime.databinding.ItemEpisodesBinding
import com.hana897trx.eclipseanime.utilities.DataUtils
import com.hana897trx.eclipseanime.utilities.GlideUtils.getInstance

class AnimeEpisodesHolder(
    private val binding: ItemEpisodesBinding
) : RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun setView(episodeData: EpisodeDataModel) = binding.apply {
        getInstance(root.context)
            .load(episodeData.episodeImgPath)
            .into(episodeCover)

        episodeNumber.text = "${root.context.getString(R.string.episode_name)} ${episodeData.episodeNumber}"
        episodeTitle.text = ""

        animeCardView.setOnClickListener {
            val bundle = bundleOf(DataUtils.ANIME_VIDEO_URL to episodeData.episodeUrl)
            it.findNavController().navigate(R.id.action_animeDetails_to_videoPlayerFragment, bundle)
        }
    }
}