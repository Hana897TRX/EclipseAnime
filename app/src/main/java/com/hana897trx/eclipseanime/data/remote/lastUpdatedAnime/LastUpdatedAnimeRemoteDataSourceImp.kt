package com.hana897trx.eclipseanime.data.remote.lastUpdatedAnime

import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.data.network.LastUpdatedAnimeApi
import com.hana897trx.eclipseanime.utilities.StatusCodes.SERVER_OFFLINE
import com.hana897trx.eclipseanime.utilities.StateResult
import com.hana897trx.eclipseanime.utilities.StatusCodes.SUCCESS
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.await
import javax.inject.Inject

class LastUpdatedAnimeRemoteDataSourceImp @Inject constructor(
    private val service : LastUpdatedAnimeApi
    ) : LastUpdatedAnimeDataSource {

    override suspend fun getLastEpisodes() : Flow<StateResult<List<AnimeModel>>> {
        return try {
            val response = service.getLastEpisodes().await()
            print(response)
            return if(response.code == SUCCESS) {
                response.data?.let { animeData ->
                    flowOf(StateResult.Success(animeData))
                } ?: flowOf(StateResult.Error(response.code, response.message ?: ""))
            }
            else {
                flowOf(StateResult.Error(response.code, response.message ?: ""))
            }
        }
        catch (e : Exception) {
            flowOf(StateResult.Error(SERVER_OFFLINE))
        }
    }
}