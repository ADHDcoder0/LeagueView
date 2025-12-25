package com.example.leagueview.vm

import android.view.View
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leagueview.data.model.Standing
import com.example.leagueview.data.repo.LaLigaRepo
import com.example.leagueview.data.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.State


@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repo: LaLigaRepo
) : ViewModel() {
    private val _standingsState =
        mutableStateOf<UiState<List<Standing>>>(UiState.Idle)

    val standingsState: State<UiState<List<Standing>>> = _standingsState

    fun fetchStandings(season: String? = null) {
        _standingsState.value = UiState.Loading

        viewModelScope.launch {
            _standingsState.value = repo.getLaLigaStandings()
        }
    }
}
