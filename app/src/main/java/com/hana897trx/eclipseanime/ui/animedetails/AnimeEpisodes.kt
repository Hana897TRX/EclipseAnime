package com.hana897trx.eclipseanime.ui.animedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.databinding.FragmentAnimeEpisodesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AnimeEpisodes.newInstance] factory method to
 * create an instance of this fragment.
 */
class AnimeEpisodes : Fragment() {

    private var animeID : String = ""
    private lateinit var binding : FragmentAnimeEpisodesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            animeID = it.getString(ANIME_ID) ?: ""
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeEpisodesBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val ANIME_ID = "EPISODE_ANIME_ID"
        @JvmStatic
        fun newInstance(animeID: String) =
            AnimeEpisodes().apply {
                arguments = Bundle().apply {
                    putString(ANIME_ID, animeID)
                }
            }
    }
}