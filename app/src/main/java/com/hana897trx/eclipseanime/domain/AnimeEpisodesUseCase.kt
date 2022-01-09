package com.hana897trx.eclipseanime.domain

import com.hana897trx.eclipseanime.data.remote.animeEpisodes.AnimeEpisodesRemoteDataSourceImp
import javax.inject.Inject

class AnimeEpisodesUseCase @Inject constructor(
    private val animeEpisodesRemoteDataSourceImp: AnimeEpisodesRemoteDataSourceImp
) {
    suspend fun invoke(animeId: String) =
        animeEpisodesRemoteDataSourceImp.getLastAnimeEpisodes(animeId)
}