package com.hana897trx.eclipseanime.data.remote.animeEpisodes

import com.hana897trx.eclipseanime.data.models.EpisodeInfoModel
import com.hana897trx.eclipseanime.utilities.StateResult
import kotlinx.coroutines.flow.Flow

interface AnimeEpisodesDataSource {
    suspend fun getLastAnimeEpisodes(animeId : String) : Flow<StateResult<EpisodeInfoModel>>
}