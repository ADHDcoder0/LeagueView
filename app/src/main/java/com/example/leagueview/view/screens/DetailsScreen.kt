package com.example.leagueview.view.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.leagueview.data.utils.UiState
import com.example.leagueview.view.components.DetailedStats
import com.example.leagueview.view.components.DetailsTop
import com.example.leagueview.view.components.TopAppBar
import com.example.leagueview.vm.DetailsScreenViewModel

@Composable
fun DetailsScreen(
    teamName: String,
    viewModel: DetailsScreenViewModel = hiltViewModel(),
    onBackClick: () -> Unit
) {
    val state = viewModel.teamState.value

    // Fetch once
    androidx.compose.runtime.LaunchedEffect(teamName) {
        viewModel.fetchTeamDetails(teamName)
    }

    when (state) {

        UiState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is UiState.Success -> {
            val standing = state.data
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                TopAppBar(
                    title = "Team Details",
                    showBack = true,
                    onBackClick = onBackClick
                )

                LazyColumn(modifier = Modifier.fillMaxSize()) {

                    item {
                        DetailsTop(standing)
                    }

                    item {
                        Spacer(modifier = Modifier.height(24.dp))
                    }
                   item {
                       Text(
                           text = "Season Performance", textAlign = TextAlign.Center,
                           style = MaterialTheme.typography.titleMedium,
                           modifier = Modifier.fillMaxWidth()
                       )
                   }
                    item {
                        DetailedStats(standing)
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
            else -> Unit
        }
    }

@Composable
fun DetailsScreenContent(
    standing: com.example.leagueview.data.model.Standing,
    onBackClick: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopAppBar(
            title = "Team Details",
            showBack = true,
            onBackClick = onBackClick
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {

            item {
                DetailsTop(standing)
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
            }

            item {
                Text(
                    text = "Season Performance",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.fillMaxWidth().padding( bottom = 12.dp),
                    textAlign = TextAlign.Center
                )
            }

            item {
                DetailedStats(standing)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    val previewStanding = com.example.leagueview.data.model.Standing(
        team = com.example.leagueview.data.model.Team(
            name = "FC Barcelona",
            logo = "https://upload.wikimedia.org/wikipedia/en/4/47/FC_Barcelona_%28crest%29.svg",
            abbreviation = "BAR"
        ),
        stats = com.example.leagueview.data.model.Stats(
            wins = 26,
            losses = 4,
            ties = 8,
            gamesPlayed = 38,
            goalsFor = 80,
            goalsAgainst = 31,
            points = 86,
            rank = 1,
            goalDifference = 49
        )
    )

    MaterialTheme {
        DetailsScreenContent(
            standing = previewStanding,
            onBackClick = {}
        )
    }
}
