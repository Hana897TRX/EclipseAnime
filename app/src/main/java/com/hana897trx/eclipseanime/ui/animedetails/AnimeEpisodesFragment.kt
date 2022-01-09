package com.hana897trx.eclipseanime.ui.animedetails

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
import com.hana897trx.eclipseanime.data.models.EpisodeInfoModel
import com.hana897trx.eclipseanime.databinding.FragmentAnimeEpisodesBinding
import com.hana897trx.eclipseanime.ui.adapter.AnimeEpisodesAdapter
import com.hana897trx.eclipseanime.utilities.AnimeEpisodeUIState
import com.hana897trx.eclipseanime.utilities.DataUtils.ANIME_ID
import com.hana897trx.eclipseanime.utilities.makeToast
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AnimeEpisodesFragment : Fragment() {

    private lateinit var binding: FragmentAnimeEpisodesBinding
    private val viewModel: AnimeEpisodesViewModel by viewModels()
    private val adapterEpisodes = AnimeEpisodesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeEpisodesBinding.inflate(inflater, container, false)
        arguments?.let {
            viewModel.searchAnime(it.getString(ANIME_ID) ?: "")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setEpisodesObserver()
    }

    private fun setEpisodesObserver() = lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
            viewModel.uiAnimeEpisodes.collect { response ->
                when (response) {
                    is AnimeEpisodeUIState.Error -> {
                        makeToast(
                            "${response.errorMessage}\nCode: ${response.errorCode}",
                            requireContext()
                        )
                    }
                    is AnimeEpisodeUIState.Loading -> {}
                    is AnimeEpisodeUIState.Success -> setView(response.data)
                }
            }
        }
    }

    private fun setView(episodeInfoModel: EpisodeInfoModel) = binding.apply {
        adapterEpisodes.submitList(episodeInfoModel.episodes)
        animeEpisodesRv.apply {
            adapter = adapterEpisodes
            layoutManager =
                LinearLayoutManager(
                    requireContext(),
                    LinearLayoutManager.VERTICAL,
                    false
                )
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(animeId: String) =
            AnimeEpisodesFragment().apply {
                arguments = Bundle().apply {
                    putString(ANIME_ID, animeId)
                }
            }
    }
}