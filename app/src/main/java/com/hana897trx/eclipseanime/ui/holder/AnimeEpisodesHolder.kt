package com.hana897trx.eclipseanime.ui.holder

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.data.models.EpisodeDataModel
import com.hana897trx.eclipseanime.databinding.ItemEpisodesBinding
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
    }
}