package com.hana897trx.eclipseanime.ui.holder

import android.annotation.SuppressLint
import android.content.Context
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.databinding.ItemAnimeEpisodesBinding

class AnimeHolder(
    private val binding : ItemAnimeEpisodesBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setView(anime : AnimeModel) = binding.apply {
        getInstance(binding.root.context)
            .load(anime.coverUrl)
            .into(animeEpisodeCover)
        animeEpisodeCover.setOnClickListener {
            it.findNavController().navigate(R.id.action_fragmentHome_to_animeDetails)
        }
    }

    companion object {
        @SuppressLint("StaticFieldLeak")
        var glide : RequestManager? = null

        fun getInstance(context : Context) : RequestManager {
            return if(glide == null) {
                glide = Glide.with(context)
                glide!!
            } else {
                glide!!
            }
        }
    }
}