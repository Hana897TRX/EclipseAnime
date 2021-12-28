package com.hana897trx.eclipseanime.domain

import com.hana897trx.eclipseanime.data.remote.EpisodesRemoteDataSourceImp
import javax.inject.Inject

class NewEpisodesUseCase @Inject constructor(
    private val getLastEpisodes : EpisodesRemoteDataSourceImp
) {
    suspend fun invoke() =
        getLastEpisodes.getLastEpisodes()
}