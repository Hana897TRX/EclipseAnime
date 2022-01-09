package com.hana897trx.eclipseanime.data.remote.lastUpdatedAnime

import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.utilities.StateResult
import kotlinx.coroutines.flow.Flow

interface LastUpdatedAnimeDataSource {
    suspend fun getLastEpisodes() : Flow<StateResult<List<AnimeModel>>>
}