package com.example.leagueview.data.repo

import android.util.Log
import com.example.leagueview.data.model.Standing
import com.example.leagueview.data.remote.LaLigaApi
import com.example.leagueview.data.utils.UiState
import javax.inject.Inject

class LaLigaRepo @Inject constructor(
    private val api: LaLigaApi
) {

    suspend fun getLaLigaStandings(): UiState<List<Standing>> {
        return try {
            val response = api.getLaLigaStandings()
            Log.d("API_CHECK", "Size = ${response.size}")
            UiState.Success(response)
        } catch (e: Exception) {
            Log.e("API_CHECK", "Error", e)
            UiState.Error(e.message ?: "Something went wrong")
        }
    }
}
