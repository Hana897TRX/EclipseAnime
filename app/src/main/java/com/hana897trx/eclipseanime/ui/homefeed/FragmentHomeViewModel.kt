package com.hana897trx.eclipseanime.ui.homefeed

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.domain.NewEpisodesUseCase
import com.hana897trx.eclipseanime.utilities.StateResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FragmentHomeViewModel @Inject constructor(
    private val newEpisodesUseCase: NewEpisodesUseCase
) : ViewModel() {

    private var _lastEpisodes : MutableStateFlow<List<AnimeModel>> = MutableStateFlow(listOf())
    val lastEpisodes : StateFlow<List<AnimeModel>> = _lastEpisodes

    init {
        getLastEpisodes()
    }

    private fun getLastEpisodes() = viewModelScope.launch(Dispatchers.IO) {
        newEpisodesUseCase.invoke().collect { stateResult ->
            when(stateResult) {
                is StateResult.Success -> { _lastEpisodes.emit(stateResult.data) }
                is StateResult.Error -> {  }
                is StateResult.Loading -> { _lastEpisodes.emit(listOf())  }
            }
        }
    }
}