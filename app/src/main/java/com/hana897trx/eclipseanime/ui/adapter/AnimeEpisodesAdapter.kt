package com.hana897trx.eclipseanime.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hana897trx.eclipseanime.data.models.EpisodeModel
import com.hana897trx.eclipseanime.databinding.ItemEpisodesBinding
import com.hana897trx.eclipseanime.ui.holder.AnimeEpisodesHolder

class AnimeEpisodesAdapter : ListAdapter<EpisodeModel, AnimeEpisodesHolder>(DiffUtilCallback()) {

    private class DiffUtilCallback : DiffUtil.ItemCallback<EpisodeModel>() {
        override fun areItemsTheSame(oldItem: EpisodeModel, newItem: EpisodeModel) =
            oldItem._id == newItem._id

        override fun areContentsTheSame(oldItem: EpisodeModel, newItem: EpisodeModel) =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        AnimeEpisodesHolder(
            ItemEpisodesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: AnimeEpisodesHolder, position: Int) {
        val episode = getItem(position)
        holder.setView(episode)
    }
}