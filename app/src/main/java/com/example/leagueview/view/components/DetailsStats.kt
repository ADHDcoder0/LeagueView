package com.example.leagueview.view.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.leagueview.R
import com.example.leagueview.data.model.Standing

@Composable
fun DetailedStats(
    standing: Standing
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        DetailsTabList("Matches Played", standing.stats.gamesPlayed.toString(),R.drawable.goal)
        DetailsTabList("Wins", standing.stats.wins.toString(),R.drawable.trophygold)
        DetailsTabList("Losses", standing.stats.losses.toString(),R.drawable.goalin)
        DetailsTabList("Ties", standing.stats.ties.toString(),R.drawable.goalin)
        DetailsTabList("Goals For", standing.stats.goalsFor.toString(),R.drawable.goalin)
        DetailsTabList("Goals Against", standing.stats.goalsAgainst.toString(),R.drawable.goal)
        DetailsTabList("Goal Difference", standing.stats.goalDifference.toString(),R.drawable.trophygold)
    }
}

