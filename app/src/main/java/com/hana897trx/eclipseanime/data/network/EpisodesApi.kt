package com.hana897trx.eclipseanime.data.network

import com.hana897trx.eclipseanime.data.models.AnimeModel
import retrofit2.Response
import retrofit2.http.GET

interface EpisodesApi {
    @GET("/lastEpisodes")
    fun getLastEpisodes() : Response<List<AnimeModel>>
}