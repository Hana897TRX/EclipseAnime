package com.hana897trx.eclipseanime.data.network

import com.hana897trx.eclipseanime.data.models.EpisodeDataModel
import com.hana897trx.eclipseanime.data.models.RemoteResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EpisodesService {
    @GET("/getEpisodes/{id}")
    fun getEpisodesById(
        @Path("id") animeId : String
    ) : Call<RemoteResponse<List<EpisodeDataModel>>>
}