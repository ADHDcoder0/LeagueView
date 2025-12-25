package com.example.leagueview.view.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StatsCardRow(
    rank: Int,
    wins: Int,
    points: Int,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        StatCard(
            label = "Rank",
            value = rank.toString(),
            modifier = Modifier.weight(1f)
        )
        StatCard(
            label = "Points",
            value = points.toString(),
            modifier = Modifier.weight(1f)
        )
        StatCard(
            label = "Wins",
            value = wins.toString(),
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StatsCardRowPrev() {
    StatsCardRow(
        rank = 2,
        wins = 26,
        points = 86,
        modifier = Modifier.padding(16.dp)
    )
}