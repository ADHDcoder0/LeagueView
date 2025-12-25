package com.example.leagueview.data.remote

import com.example.leagueview.data.model.Standing
import retrofit2.http.GET
import retrofit2.http.Headers
import javax.inject.Singleton

@Singleton
interface LaLigaApi {


        @Headers(
            "x-rapidapi-key: 87a03a2bd0mshadebc83ca20892ap11be71jsn4cb16a3242fe",
            "x-rapidapi-host: laliga-standings.p.rapidapi.com"
        )
        @GET("/")
        suspend fun getLaLigaStandings(): List<Standing>
    }