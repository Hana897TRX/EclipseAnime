package com.hana897trx.eclipseanime.ui.homefeed

import androidx.lifecycle.ViewModel
import com.hana897trx.eclipseanime.domain.NewEpisodesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FragmentHomeViewModel @Inject constructor(
    private val newEpisodesUseCase: NewEpisodesUseCase
) : ViewModel() {
}