package com.hana897trx.eclipseanime.core.di

import android.app.Activity
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.hana897trx.eclipseanime.data.network.EpisodesApi
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideGlide(@ApplicationContext context : Context) : RequestManager {
        return Glide.with(context)
    }

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
    fun provideApiEpisodes(retrofit: Retrofit) : EpisodesApi {
        return retrofit.create(EpisodesApi::class.java)
    }
}