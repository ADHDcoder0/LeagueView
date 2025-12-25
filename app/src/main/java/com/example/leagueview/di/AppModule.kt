package com.example.leagueview.di

import com.example.leagueview.data.remote.LaLigaApi
import com.example.leagueview.data.repo.LaLigaRepo
import com.example.leagueview.data.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideLaLigaRepo(
        api: LaLigaApi
    ) = LaLigaRepo(api)

    @Singleton
    @Provides
    fun provideLaLigaApi(): LaLigaApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(LaLigaApi::class.java)
    }
}
