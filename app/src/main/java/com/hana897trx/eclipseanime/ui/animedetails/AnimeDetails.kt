package com.hana897trx.eclipseanime.ui.animedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.databinding.FragmentAnimeDetailsBinding
import com.hana897trx.eclipseanime.ui.adapter.AnimeViewPaggerAdapter
import com.hana897trx.eclipseanime.utilities.DataUtils.ANIME_CODE

class AnimeDetails : Fragment() {

    private lateinit var binding : FragmentAnimeDetailsBinding
    private lateinit var animeData : AnimeModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            animeData = it.getParcelable(ANIME_CODE)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAnimeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
    }

    private fun setViewPager() = binding.apply {
        animeDetailsViewPagger.apply {
            adapter = AnimeViewPaggerAdapter(
                lifecycle,
                this@AnimeDetails.childFragmentManager,
                animeData._id ?: ""
            )
        }
    }
}