package hu.nmth.afd.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.ui.components.AfdAppBar
import hu.nmth.afd.designsystem.ui.components.buttons.AfdButton
import hu.nmth.afd.feature.home.components.HomeLeaderBoard
import hu.nmth.afd.feature.home.components.NewGameCard

@Composable
fun HomeScreen(
    navigateToNewGame: () -> Unit,
    navigateToPlayers: () -> Unit,
) {
    HomeContent(
        navigateToNewGame = navigateToNewGame,
        navigateToPlayers = navigateToPlayers,
    )
}

@Composable
private fun HomeContent(
    navigateToNewGame: () -> Unit,
    navigateToPlayers: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            AfdAppBar(title = stringResource(id = R.string.app_bar_title))

            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.spacing400),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                NewGameCard(
                    modifier = Modifier
                        .padding(top = MaterialTheme.spacing.spacing600)
                        .padding(horizontal = MaterialTheme.spacing.spacing400),
                    startGameCreate = navigateToNewGame
                )

                HomeLeaderBoard()

                AfdButton(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .padding(bottom = MaterialTheme.spacing.spacing300)
                        .padding(horizontal = MaterialTheme.spacing.spacing400),
                    label = stringResource(id = R.string.home_edit_players_button_label),
                    onClick = navigateToPlayers
                )
            }
        }

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AfdTheme {
        HomeContent(
            navigateToNewGame = {},
            navigateToPlayers = {}
        )
    }
}