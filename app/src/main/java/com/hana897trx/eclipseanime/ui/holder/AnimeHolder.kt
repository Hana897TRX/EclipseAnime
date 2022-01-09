package com.hana897trx.eclipseanime.ui.holder

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.databinding.ItemAnimeEpisodesBinding
import com.hana897trx.eclipseanime.utilities.DataUtils.ANIME_CODE
import com.hana897trx.eclipseanime.utilities.GlideUtils.getInstance

class AnimeHolder(
    private val binding : ItemAnimeEpisodesBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setView(anime : AnimeModel) = binding.apply {
        getInstance(binding.root.context)
            .load(anime.coverUrl)
            .into(animeEpisodeCover)

        animeEpisodeCover.setOnClickListener {
            val bundle = bundleOf(ANIME_CODE to anime )
            it.findNavController().navigate(R.id.action_fragmentHome_to_animeDetails, bundle)
        }
    }
}