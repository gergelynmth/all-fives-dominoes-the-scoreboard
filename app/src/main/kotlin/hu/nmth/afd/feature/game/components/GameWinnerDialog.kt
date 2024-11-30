package hu.nmth.afd.feature.game.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.TextNeutralSubtle
import hu.nmth.afd.designsystem.ui.components.buttons.AfdButton
import hu.nmth.afd.designsystem.ui.components.buttons.AfdButtonStyle
import hu.nmth.afd.designsystem.ui.components.dialogs.AfdDialog

@Composable
fun GameWinnerDialog(
    winner: String,
    score: String,
    onPositiveClicked: () -> Unit,
    onDismissRequest: () -> Unit
) {
    AfdDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            text = stringResource(id = R.string.game_winner_dialog_title),
            style = MaterialTheme.typography.titleLarge,
            color = TextBrandStrong
        )

        Text(
            text = winner,
            style = MaterialTheme.typography.headlineLarge,
            color = TextBrandStrong
        )

        Text(
            text = stringResource(id = R.string.game_winner_dialog_score, score),
            style = MaterialTheme.typography.headlineSmall,
            color = TextNeutralSubtle
        )

        AfdButton(
            label = stringResource(id = R.string.button_okay),
            style = AfdButtonStyle.PRIMARY,
            onClick = onPositiveClicked
        )
    }
}

@Preview
@Composable
private fun GameWinnerDialogPreview() {
    AfdTheme {
        GameWinnerDialog(
            winner = "Anna",
            score = "120",
            onPositiveClicked = {},
            onDismissRequest = {}
        )
    }
}