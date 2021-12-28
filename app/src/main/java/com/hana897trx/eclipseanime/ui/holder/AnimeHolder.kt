package com.hana897trx.eclipseanime.ui.holder

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.databinding.ItemAnimeEpisodesBinding

class AnimeHolder(
    private val binding : ItemAnimeEpisodesBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun setView(anime : AnimeModel) = binding.apply {
        getInstance(binding.root.context)
            .load(anime.coverUrl)
            .into(animeEpisodeCover)
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