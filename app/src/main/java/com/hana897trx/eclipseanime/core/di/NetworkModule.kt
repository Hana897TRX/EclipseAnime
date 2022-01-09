package com.hana897trx.eclipseanime.core.di

import com.hana897trx.eclipseanime.data.network.EpisodeService
import com.hana897trx.eclipseanime.data.network.LastUpdatedAnimeApi
import com.hana897trx.eclipseanime.utilities.APIData.APIBase
import com.hana897trx.eclipseanime.utilities.APIData.URLBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    // Retrofit
    @Singleton
    @Provides
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl("${URLBase}${APIBase}")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiEpisodes(retrofit: Retrofit) : LastUpdatedAnimeApi {
        return retrofit.create(LastUpdatedAnimeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideApiEpisodesService(retrofit: Retrofit) : EpisodeService {
        return retrofit.create(EpisodeService::class.java)
    }
}