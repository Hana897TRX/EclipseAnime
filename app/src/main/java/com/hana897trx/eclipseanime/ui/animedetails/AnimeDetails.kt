package com.hana897trx.eclipseanime.ui.animedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hana897trx.eclipseanime.databinding.FragmentAnimeDetailsBinding

class AnimeDetails : Fragment() {

    private lateinit var binding : FragmentAnimeDetailsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAnimeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
    
}