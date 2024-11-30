package hu.nmth.afd.feature.game.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.DividerNeutralSubtle
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.feature.game.model.PlayerScore

@Composable
fun PlayersBoard(
    modifier: Modifier = Modifier,
    playerScores: List<PlayerScore>,
    currentPlayer: PlayerScore?,
    onPlayerSelected: (PlayerScore) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        playerScores.forEachIndexed { index, playerScore ->
            PlayerBoardColumn(
                modifier = Modifier.weight(1f),
                playerName = playerScore.name,
                playerScores = playerScore.scores,
                isCurrentPlayer = playerScore.id == currentPlayer!!.id,
                onPlayerSelected = { onPlayerSelected(playerScore) }
            )

            if (index != playerScores.lastIndex) {
                VerticalDivider(
                    thickness = MaterialTheme.spacing.spacing050,
                    color = DividerNeutralSubtle
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlayersBoardPreview() {
    PlayersBoard(
        playerScores = listOf(
            PlayerScore(
                id = 0,
                name = "Joseph",
                scores = listOf(5, 10)
            ),
            PlayerScore(
                id = 1,
                name = "Maria",
                scores = listOf(10, 20)
            )
        ),
        currentPlayer = PlayerScore(
            id = 1,
            name = "Maria",
            scores = listOf(10, 20)
        ),
        onPlayerSelected = {}
    )
}

