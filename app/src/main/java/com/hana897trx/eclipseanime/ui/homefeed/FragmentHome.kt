package com.hana897trx.eclipseanime.ui.homefeed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.databinding.FragmentHomeBinding
import com.hana897trx.eclipseanime.ui.adapter.EpisodesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentHome : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel : FragmentHomeViewModel by viewModels()
    private var episodesAdapter = EpisodesAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setRecycler()
        setEpisodesObserver()
    }

    private fun setEpisodesObserver() = lifecycleScope.launch {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            viewModel.lastEpisodes.collect { episodes ->
                setRecycler(episodes)
            }
        }
    }

    private fun setRecycler(episodesData : List<AnimeModel>) = binding.apply { // This is view Binding, will help to supply data to views
        episodesAdapter.submitList(episodesData)
        homeRecyclerNewChapters.apply {
            adapter = episodesAdapter
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }
}