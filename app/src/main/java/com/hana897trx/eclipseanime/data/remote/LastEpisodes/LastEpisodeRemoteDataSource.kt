package com.hana897trx.eclipseanime.data.remote.LastEpisodes

import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.utilities.StateResult
import kotlinx.coroutines.flow.Flow

interface LastEpisodeRemoteDataSource {
    suspend fun getLastEpisodes() : Flow<StateResult<List<AnimeModel>>>
}