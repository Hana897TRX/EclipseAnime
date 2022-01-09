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
import com.hana897trx.eclipseanime.utilities.GlideUtils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailsFragment : Fragment() {

    private lateinit var binding: FragmentAnimeDetailsBinding
    private lateinit var animeData: AnimeModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeDetailsBinding.inflate(inflater, container, false)
        arguments?.let {
            animeData = it.getParcelable(ANIME_CODE) ?: AnimeModel()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewPager()
        setView()
    }

    private fun setView() = binding.apply {
        animeData.animeName?.let {
            animeDetailsTitle.text = it
        }

        animeData.alternaTitle?.let {
            if(it.isEmpty()) {
                animeDetailsAlterTitle.text = animeData.animeName
            }
            else {
                animeDetailsAlterTitle.text = it
            }
        }

        animeData.animeDescription?.let {
            animeDetailsDescription.text = it
        }

        animeData.coverUrl?.let {
            GlideUtils
                .getInstance(requireContext())
                .load(it)
                .into(animeDetailsVideo)
        }
    }

    private fun setViewPager() = binding.apply {
        animeDetailsViewPagger.apply {
            adapter = AnimeViewPaggerAdapter(
                lifecycle,
                this@AnimeDetailsFragment.childFragmentManager,
                animeData._id ?: ""
            )
        }
    }
}