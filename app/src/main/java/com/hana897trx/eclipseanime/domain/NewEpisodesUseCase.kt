package com.hana897trx.eclipseanime.domain

import com.hana897trx.eclipseanime.data.remote.LastEpisodes.LastEpisodesRemoteDataSourceImpLast
import javax.inject.Inject

class NewEpisodesUseCase @Inject constructor(
    private val getLastLastEpisodes : LastEpisodesRemoteDataSourceImpLast
) {
    suspend fun invoke() =
        getLastLastEpisodes.getLastEpisodes()
}