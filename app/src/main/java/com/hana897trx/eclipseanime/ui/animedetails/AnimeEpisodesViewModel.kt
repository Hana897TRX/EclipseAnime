package com.hana897trx.eclipseanime.ui.animedetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hana897trx.eclipseanime.domain.AnimeEpisodesUseCase
import com.hana897trx.eclipseanime.utilities.AnimeEpisodeUIState
import com.hana897trx.eclipseanime.utilities.StateResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeEpisodesViewModel @Inject constructor(
    private val animeEpisodesUseCase: AnimeEpisodesUseCase
) : ViewModel() {
    private val _uiAnimeEpisodes : MutableStateFlow<AnimeEpisodeUIState> = MutableStateFlow(AnimeEpisodeUIState.Loading(false))
    val uiAnimeEpisodes : StateFlow<AnimeEpisodeUIState> = _uiAnimeEpisodes

    fun searchAnime(animeId : String) = viewModelScope.launch(Dispatchers.IO) {
        animeEpisodesUseCase.invoke(animeId).collect { response ->
            when(response) {
                is StateResult.Error -> { _uiAnimeEpisodes.emit(AnimeEpisodeUIState.Error(response.errorCode, response.errorMessage)) }
                is StateResult.Loading -> { _uiAnimeEpisodes.emit(AnimeEpisodeUIState.Loading(response.isLoading)) }
                is StateResult.Success -> { _uiAnimeEpisodes.emit(AnimeEpisodeUIState.Success(response.data)) }
            }
        }
    }
}
