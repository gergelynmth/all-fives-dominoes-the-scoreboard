package hu.nmth.afd.feature.players

import androidx.compose.runtime.Composable
import org.koin.androidx.compose.koinViewModel

@Composable
fun PlayersScreen(
    viewModel: PlayersViewModel = koinViewModel<PlayersViewModel>(),
) {
    PlayersContent()
}

@Composable
fun PlayersContent() {

}