package com.hana897trx.eclipseanime.domain

import com.hana897trx.eclipseanime.data.remote.lastUpdatedAnime.LastUpdatedAnimeRemoteDataSourceImp
import javax.inject.Inject

class LastUpdatedAnimeUseCase @Inject constructor(
    private val getLastLastEpisodes : LastUpdatedAnimeRemoteDataSourceImp
) {
    suspend fun invoke() =
        getLastLastEpisodes.getLastEpisodes()
}