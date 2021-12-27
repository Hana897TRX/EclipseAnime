package com.hana897trx.eclipseanime.ui.episodedetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.databinding.FragmentHomeBinding
import com.hana897trx.eclipseanime.utilities.RecyclerAdapter


class FragmentHome : Fragment() {

    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
    }

    private fun setRecycler() = binding.apply { // This is view Binding, will help to supply data to views
        homeRecyclerNewChapters.apply {
            adapter = RecyclerAdapter()
            layoutManager = LinearLayoutManager(
                requireContext(),
                LinearLayoutManager.HORIZONTAL,
                false
            )
        }
    }
}