package com.hana897trx.eclipseanime.core.di

import com.hana897trx.eclipseanime.data.network.EpisodesService
import com.hana897trx.eclipseanime.data.network.LastEpisodesApi
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
            .baseUrl("http://192.168.1.76:5000/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiEpisodes(retrofit: Retrofit) : LastEpisodesApi {
        return retrofit.create(LastEpisodesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideApiEpisodesService(retrofit: Retrofit) : EpisodesService {
        return retrofit.create(EpisodesService::class.java)
    }
}