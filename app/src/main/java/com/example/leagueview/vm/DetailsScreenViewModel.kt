package com.example.leagueview.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.leagueview.data.model.Standing
import com.example.leagueview.data.repo.LaLigaRepo
import com.example.leagueview.data.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsScreenViewModel @Inject constructor(
    private val repo: LaLigaRepo
) : ViewModel() {

    private val _teamState = mutableStateOf<UiState<Standing>>(UiState.Idle)
    val teamState: State<UiState<Standing>> = _teamState

    fun fetchTeamDetails(teamName: String) {
        _teamState.value = UiState.Loading

        viewModelScope.launch {
            when (val result = repo.getLaLigaStandings()) {

                is UiState.Success -> {
                    val team = result.data.find {
                        it.team.name.equals(teamName, ignoreCase = true)
                    }

                    if (team != null) {
                        _teamState.value = UiState.Success(team)
                    } else {
                        _teamState.value =
                            UiState.Error("Team not found")
                    }
                }

                is UiState.Error -> {
                    _teamState.value = UiState.Error(result.message)
                }

                else -> Unit
            }
        }
    }
}
