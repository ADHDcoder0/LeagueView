package com.example.leagueview.view.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.leagueview.data.utils.UiState
import com.example.leagueview.view.components.TeamTile
import com.example.leagueview.view.components.TopAppBar
import com.example.leagueview.vm.HomeScreenViewModel

@Composable
fun HomeScreen(
    onClick: (String) -> Unit,
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val state = viewModel.standingsState.value

    // Fetch data once when screen loads
    LaunchedEffect(Unit) {
        viewModel.fetchStandings("2022")
    }

    when (state) {

        UiState.Idle -> {}

        UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiState.Success -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TopAppBar("LaLiGa",false,{})

                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(
                        items = state.data,
                        key = { it.team.abbreviation } // stable key
                    ) { standing ->
                        TeamTile(
                            standing = standing,
                            onClick = {
                                onClick(standing.team.name)
                            }
                        )
                    }
                }
            }
        }
        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = state.message)
            }
        }
    }
}
