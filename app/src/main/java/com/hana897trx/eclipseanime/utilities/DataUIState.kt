package com.hana897trx.eclipseanime.utilities

import com.hana897trx.eclipseanime.data.models.EpisodeInfoModel

sealed class AnimeEpisodeUIState {
    data class Error(var errorCode : Int, var errorMessage : String = "") : AnimeEpisodeUIState()
    data class Success(var data : EpisodeInfoModel) : AnimeEpisodeUIState()
    data class Loading(var isLoading : Boolean) : AnimeEpisodeUIState()
}
