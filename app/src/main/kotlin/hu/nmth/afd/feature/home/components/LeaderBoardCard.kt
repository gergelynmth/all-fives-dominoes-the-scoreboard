package hu.nmth.afd.feature.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.WhiteBackground
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing

enum class LeaderBoardCardPlace(val color: Color, val place: String) {
    First(MainOrange, "1"),
    Second(MainOrange.copy(alpha = 0.5f), "2"),
    Third(MainOrange.copy(alpha = 0.2f), "3")
}

@Composable
fun LeaderBoardCard(
    modifier: Modifier = Modifier,
    place: LeaderBoardCardPlace,
    player: String,
    wins: String,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shape.radius400)
            .background(place.color, MaterialTheme.shape.radius400)
            .padding(MaterialTheme.spacing.spacing200),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing300)
    ) {
        Box(
            modifier = Modifier
                .size(MaterialTheme.spacing.spacing1000)
                .background(WhiteBackground, MaterialTheme.shape.rounded),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = place.place,
                style = MaterialTheme.typography.bodyLarge,
                color = TextBrandStrong,
                overflow = TextOverflow.Ellipsis
            )
        }

        Text(
            modifier = Modifier.weight(1f),
            text = player,
            style = MaterialTheme.typography.titleLarge,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            modifier = Modifier.padding(end = MaterialTheme.spacing.spacing200),
            text = wins,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview
@Composable
private fun LeaderBoardCardPreview() {
    AfdTheme {
        LeaderBoardCard(
            player = "Anna",
            place = LeaderBoardCardPlace.First,
            wins = "10"
        )
    }
}