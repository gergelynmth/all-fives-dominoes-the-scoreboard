package hu.nmth.afd.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.spacing

@Composable
fun HomeLeaderBoard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing300)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = MaterialTheme.spacing.spacing400),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                text = stringResource(id = R.string.home_leaderboard_title),
                style = MaterialTheme.typography.headlineLarge,
                color = TextBrandStrong
            )

            Text(
                text = stringResource(id = R.string.home_leaderboard_wins_title),
                style = MaterialTheme.typography.bodyLarge,
                color = TextBrandStrong
            )
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing300)
        ) {

            LeaderBoardCard(
                player = "Anna",
                place = LeaderBoardCardPlace.First,
                wins = "999"
            )

            LeaderBoardCard(
                player = "Anna megint",
                place = LeaderBoardCardPlace.Second,
                wins = "10"
            )

            LeaderBoardCard(
                player = "Geri",
                place = LeaderBoardCardPlace.Third,
                wins = "1"
            )
        }
    }
}