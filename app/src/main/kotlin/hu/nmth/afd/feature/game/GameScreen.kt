package hu.nmth.afd.feature.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.icons.AfdIcons
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.BackgroundNeutral
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.ui.components.AfdAppBar
import hu.nmth.afd.feature.game.components.GameNumberKeyboard
import hu.nmth.afd.feature.game.components.GameWinnerDialog
import hu.nmth.afd.feature.game.components.PlayersBoard
import hu.nmth.afd.feature.game.components.ScoreDisplay
import hu.nmth.afd.feature.game.model.PlayerScore
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun GameScreen(
    navParameters: GameScreenDestination,
    viewModel: GameViewModel = koinViewModel<GameViewModel> {
        parametersOf(
            navParameters.player1,
            navParameters.player2,
            navParameters.player3,
            navParameters.player4
        )
    },
    navigateToHome: () -> Unit
) {
    val state by viewModel.state.collectAsState()

    GameContent(
        players = state.players,
        currentPlayer = state.currentPlayer,
        currentScore = state.currentScore,
        handleIntent = { viewModel.handleIntent(it) }
    )

    if (state.winner != null) {
        val winner = state.winner
        val lastScore = winner?.scores?.lastOrNull() ?: 0

        GameWinnerDialog(
            winner = winner?.name ?: "",
            score = lastScore.toString(),
            onDismissRequest = {},
            onPositiveClicked = navigateToHome
        )
    }
}

@Composable
private fun GameContent(
    players: List<PlayerScore>,
    currentPlayer: PlayerScore?,
    currentScore: String,
    handleIntent: (GameIntent) -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundNeutral)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight()
        ) {

            // AppBar
            AfdAppBar(
                title = stringResource(R.string.app_bar_title),
                tailingIcon = {
                    IconButton(
                        modifier = Modifier
                            .size(MaterialTheme.spacing.spacing1000)
                            .clip(MaterialTheme.shape.rounded),
                        onClick = { handleIntent(GameIntent.Replay) }
                    ) {
                        Icon(
                            painter = painterResource(id = AfdIcons.Replay),
                            contentDescription = null,
                            tint = TextBrandStrong
                        )
                    }
                }
            )

            // PlayersBoard
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                PlayersBoard(
                    playerScores = players,
                    currentPlayer = currentPlayer,
                    onPlayerSelected = { handleIntent(GameIntent.PlayerSelected(it)) }
                )
            }

            // ScoreDisplay and keyboard
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding()
                    .padding(bottom = MaterialTheme.spacing.spacing200),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                ScoreDisplay(
                    modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing400),
                    score = currentScore,
                    onAddClicked = { handleIntent(GameIntent.AddScoreToPlayer) }
                )

                GameNumberKeyboard(
                    modifier = Modifier.padding(top = MaterialTheme.spacing.spacing200),
                    onNumberClicked = { handleIntent(GameIntent.AddScore(it)) },
                    onDeleteClicked = { handleIntent(GameIntent.DeleteScoreByOne) }
                )
            }
        }
    }
}

@Preview
@Composable
internal fun GameScreenPreview() {
    AfdTheme {
        GameContent(
            players = listOf(
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
            currentScore = "0",
            handleIntent = {}
        )
    }
}