package com.hana897trx.eclipseanime.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.databinding.ItemAnimeEpisodesBinding
import com.hana897trx.eclipseanime.ui.holder.AnimeHolder

class EpisodesAdapter : ListAdapter<AnimeModel, AnimeHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AnimeHolder(
            ItemAnimeEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AnimeHolder, position: Int) {
        val anime = getItem(position)
        holder.setView(anime)
    }
}

private class DiffUtilCallback : DiffUtil.ItemCallback<AnimeModel>() {
    override fun areItemsTheSame(oldItem: AnimeModel, newItem: AnimeModel) =
        oldItem._id == newItem._id

    override fun areContentsTheSame(oldItem: AnimeModel, newItem: AnimeModel) =
        oldItem == newItem
}