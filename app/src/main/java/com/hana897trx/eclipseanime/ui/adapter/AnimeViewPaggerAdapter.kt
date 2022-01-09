package com.hana897trx.eclipseanime.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.hana897trx.eclipseanime.ui.animedetails.AnimeEpisodesFragment

class AnimeViewPaggerAdapter(
    lifecycle: Lifecycle,
    fragmentManager: FragmentManager,
    private val animeId : String
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> { AnimeEpisodesFragment.newInstance(animeId) }
            1 -> { AnimeEpisodesFragment.newInstance(animeId) }
            2 -> { AnimeEpisodesFragment.newInstance(animeId) }
            else -> { AnimeEpisodesFragment.newInstance(animeId) }:wq:wq
        }
    }
}