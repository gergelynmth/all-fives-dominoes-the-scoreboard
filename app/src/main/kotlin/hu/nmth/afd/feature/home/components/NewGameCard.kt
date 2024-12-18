package hu.nmth.afd.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.ui.components.buttons.AfdButton

@Composable
fun NewGameCard(
    modifier: Modifier = Modifier,
    startGameCreate: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing200)
    ) {
        Text(
            text = stringResource(id = R.string.home_create_new_game_title),
            style = MaterialTheme.typography.headlineLarge,
            color = TextBrandStrong
        )

        AfdButton(
            label = stringResource(id = R.string.home_create_new_game_button_label),
            onClick = startGameCreate
        )
    }
}

@Preview
@Composable
private fun NewGameCardPreview() {
    AfdTheme {
        NewGameCard(
            startGameCreate = {}
        )
    }
}