package com.hana897trx.eclipseanime.data.remote.LastEpisodes

import com.hana897trx.eclipseanime.R
import com.hana897trx.eclipseanime.data.models.AnimeModel
import com.hana897trx.eclipseanime.data.network.LastEpisodesApi
import com.hana897trx.eclipseanime.utilities.ErrorCodes.EMPTY_DATA
import com.hana897trx.eclipseanime.utilities.ErrorCodes.SERVER_OFFLINE
import com.hana897trx.eclipseanime.utilities.StateResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import retrofit2.await
import javax.inject.Inject

class LastEpisodesRemoteDataSourceImpLast @Inject constructor(
    private val service : LastEpisodesApi
    ) : LastEpisodeRemoteDataSource {

    override suspend fun getLastEpisodes() : Flow<StateResult<List<AnimeModel>>> {
        val response = service.getLastEpisodes().await()
        print(response)
        return if(response.message == "success") {
            response.data?.let { animeData ->
                flowOf(StateResult.Success(animeData))
            } ?: flowOf(StateResult.Error(R.string.episodes_api_information_empty, EMPTY_DATA))
        }
        else {
            flowOf(StateResult.Error(R.string.episodes_api_server_not_responding, SERVER_OFFLINE))
        }
    }
}