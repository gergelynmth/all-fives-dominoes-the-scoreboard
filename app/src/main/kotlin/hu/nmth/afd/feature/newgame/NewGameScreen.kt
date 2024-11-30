package hu.nmth.afd.feature.newgame

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.icons.AfdIcons
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.BackgroundNeutral
import hu.nmth.afd.designsystem.theme.DividerNeutralSubtle
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.TextNeutralSubtle
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.ui.components.AfdAppBar
import hu.nmth.afd.designsystem.ui.components.buttons.AfdButton
import hu.nmth.afd.designsystem.ui.components.buttons.AfdTextButton
import hu.nmth.afd.designsystem.ui.components.icons.BouncingIcon
import hu.nmth.afd.domain.model.Player
import hu.nmth.afd.feature.newgame.components.AddNewPlayerDialog
import hu.nmth.afd.feature.newgame.components.AdfCheckBoxCard
import org.koin.androidx.compose.koinViewModel

@Composable
fun NewGameScreen(
    viewModel: NewGameViewModel = koinViewModel<NewGameViewModel>(),
    navigateToGame: (List<Player>) -> Unit
) {
    val state by viewModel.state.collectAsState()

    var showNewPlayerDialog by remember { mutableStateOf(false) }

    LaunchedEffect(viewModel) {
        viewModel.handleIntent(NewGameIntent.LoadPlayers)
    }

    NewGameContent(
        players = state.players,
        selectedPlayers = state.selectedPlayers,
        isSetupReady = state.isSetupReady,
        onPlayerSelected = { viewModel.handleIntent(NewGameIntent.OnPlayerSelected(it)) },
        onAddNewPlayer = { showNewPlayerDialog = true },
        startGame = { navigateToGame(state.selectedPlayers) }
    )

    if (showNewPlayerDialog) {
        AddNewPlayerDialog(
            onDismissRequest = { showNewPlayerDialog = false },
            onAddClicked = { name ->
                viewModel.handleIntent(NewGameIntent.AddPlayer(name))
                showNewPlayerDialog = false
            }
        )
    }
}

@Composable
private fun NewGameContent(
    players: List<Player>,
    selectedPlayers: List<Player>,
    isSetupReady: Boolean,
    onPlayerSelected: (Player) -> Unit,
    onAddNewPlayer: () -> Unit,
    startGame: () -> Unit
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
            // Appbar
            AfdAppBar(title = stringResource(R.string.new_game_title))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = MaterialTheme.spacing.spacing200)
            ) {

                // Title and new player
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = MaterialTheme.spacing.spacing400)
                        .padding(bottom = MaterialTheme.spacing.spacing300),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.new_game_select_player),
                        style = MaterialTheme.typography.bodyLarge,
                        color = TextNeutralSubtle
                    )

                    AfdTextButton(
                        label = stringResource(id = R.string.new_game_add_new_player),
                        headingIcon = painterResource(id = AfdIcons.Add),
                        onClick = onAddNewPlayer
                    )
                }

                // if players is empty, show add new player text, if not show the players
                if (players.isEmpty()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f)
                            .padding(horizontal = MaterialTheme.spacing.spacing400),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = stringResource(id = R.string.new_game_select_no_player),
                            style = MaterialTheme.typography.titleLarge,
                            color = TextBrandStrong
                        )

                        BouncingIcon(
                            modifier = Modifier.padding(end = MaterialTheme.spacing.spacing400),
                            painter = painterResource(id = AfdIcons.ArrowUpward),
                        )
                    }
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = MaterialTheme.spacing.spacing400)
                            .weight(1f),
                        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing400)
                    ) {
                        items(players) { player ->
                            AdfCheckBoxCard(
                                label = player.name,
                                checked = selectedPlayers.contains(player),
                                onClick = { onPlayerSelected(player) }
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .navigationBarsPadding()
                        .padding(bottom = MaterialTheme.spacing.spacing300),
                    verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing200)
                ) {
                    HorizontalDivider(
                        thickness = MaterialTheme.spacing.spacing050,
                        color = DividerNeutralSubtle
                    )

                    Row(
                        modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing400),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing100)
                    ) {
                        Text(
                            text = stringResource(R.string.new_game_selected),
                            style = MaterialTheme.typography.bodyLarge,
                            color = TextNeutralSubtle
                        )

                        Text(
                            text = selectedPlayers.joinToString(", ") { it.name },
                            style = MaterialTheme.typography.titleMedium,
                            color = MainOrange
                        )
                    }

                    AfdButton(
                        modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing400),
                        label = stringResource(R.string.new_game_start_game),
                        onClick = startGame,
                        enabled = isSetupReady
                    )
                }
            }
        }
    }
}


@Preview
@Composable
internal fun NewGameScreenPreview() {
    AfdTheme {
        NewGameContent(
            players = emptyList(),
            selectedPlayers = emptyList(),
            isSetupReady = true,
            onPlayerSelected = {},
            onAddNewPlayer = {},
            startGame = {}
        )
    }
}