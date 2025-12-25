package com.example.leagueview.view.components

import android.R.attr.onClick
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.leagueview.data.model.Standing

@Composable
fun TeamTile(standing: Standing,
             onClick: () -> Unit
             ) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(155.dp)

    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .align(Alignment.BottomCenter)
                .clickable { onClick() },
            shape = RoundedCornerShape(20.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp)
            ) {

                Column(
                    modifier = Modifier.align(Alignment.CenterStart).padding(6.dp)
                ) {
                    Text("LALIGA 2022", style = MaterialTheme.typography.labelSmall)
                    Spacer(Modifier.height(4.dp))
                    Text(
                        text = standing.team.name.uppercase(),
                        style = MaterialTheme.typography.headlineLarge
                    )
                    Spacer(Modifier.height(8.dp))
                    Text("${standing.stats.rank} Place")
                    Spacer(Modifier.height(4.dp))
                    Text("${standing.stats.points} pts")
                }
            }
        }


        AsyncImage(
            model = standing.team.logo,
            contentDescription = standing.team.name,
            modifier = Modifier
                .padding(top=8.dp)
                .size(130.dp)
                .align(Alignment.CenterEnd),
            contentScale = ContentScale.Fit
        )
    }
}




