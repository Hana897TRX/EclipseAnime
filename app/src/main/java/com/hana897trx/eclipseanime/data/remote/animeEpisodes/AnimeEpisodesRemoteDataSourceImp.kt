package com.hana897trx.eclipseanime.data.remote.animeEpisodes

import com.hana897trx.eclipseanime.data.models.EpisodeInfoModel
import com.hana897trx.eclipseanime.data.network.EpisodeService
import com.hana897trx.eclipseanime.utilities.StatusCodes
import com.hana897trx.eclipseanime.utilities.StateResult
import com.hana897trx.eclipseanime.utilities.StatusCodes.SUCCESS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.await
import java.lang.Exception
import javax.inject.Inject

class AnimeEpisodesRemoteDataSourceImp @Inject constructor(
    private val service: EpisodeService
) : AnimeEpisodesDataSource {
    override suspend fun getLastAnimeEpisodes(animeId: String): Flow<StateResult<EpisodeInfoModel>> {
        return try {
            val response = service.getEpisodesById(animeId).await()
            if (response.code == SUCCESS) {
                response.data?.get(0)?.let {
                    flowOf(StateResult.Success(it))
                } ?: flowOf(StateResult.Error(response.code, response.message ?: ""))
            } else {
                flowOf(StateResult.Error(response.code, response.message ?: ""))
            }
        } catch (e: Exception) {
            flowOf(StateResult.Error(StatusCodes.SERVER_OFFLINE))
        }
    }
}