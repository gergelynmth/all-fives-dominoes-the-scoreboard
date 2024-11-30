package hu.nmth.afd.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.ui.components.AfdAppBar

@Composable
fun HomeScreen(
    navigateToNewGame: () -> Unit
) {
    HomeContent(
        navigateToNewGame = navigateToNewGame
    )
}

@Composable
private fun HomeContent(
    navigateToNewGame: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            AfdAppBar(title = stringResource(id = R.string.app_bar_title))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = MaterialTheme.spacing.spacing400)
            ) {
                // Title of create new game
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(id = R.string.home_create_new_game_title),
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Button(
                    onClick = navigateToNewGame
                ) {
                    Text(text = "navigate to new game")
                }
            }
        }

    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AfdTheme {
        HomeContent(
            navigateToNewGame = {}
        )
    }
}