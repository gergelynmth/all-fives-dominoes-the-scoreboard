package hu.nmth.afd.feature.newgame.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.ui.components.buttons.AfdButton
import hu.nmth.afd.designsystem.ui.components.buttons.AfdButtonStyle
import hu.nmth.afd.designsystem.ui.components.dialogs.AfdDialog
import hu.nmth.afd.designsystem.ui.components.textfields.AfdTextField

@Composable
fun AddNewPlayerDialog(
    onDismissRequest: () -> Unit,
    onAddClicked: (String) -> Unit
) {
    val playerName = remember { mutableStateOf("") }
    var error by remember { mutableStateOf(false) }

    AfdDialog(
        onDismissRequest = onDismissRequest
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = stringResource(id = R.string.new_game_add_new_player_dialog_title),
            style = MaterialTheme.typography.headlineSmall,
            color = TextBrandStrong,
            textAlign = TextAlign.Center
        )

        AfdTextField(
            text = playerName.value,
            onTextChange = { playerName.value = it },
            placeholder = stringResource(id = R.string.new_game_add_new_player_dialog_text_field_placeholder),
            feedback =
            if (error) {
                stringResource(id = R.string.new_game_add_new_player_dialog_text_field_placeholder_error)
            } else {
                null
            },
            maxCharacters = 25
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing400)
        ) {
            AfdButton(
                label = stringResource(R.string.new_game_add_new_player),
                style = AfdButtonStyle.PRIMARY,
                onClick = {
                    if (playerName.value.isEmpty()) {
                        error = true
                    } else {
                        onAddClicked(playerName.value)
                    }
                }
            )

            AfdButton(
                label = stringResource(id = R.string.button_cancel),
                style = AfdButtonStyle.NEGATIVE,
                onClick = onDismissRequest
            )
        }
    }
}


@Preview
@Composable
private fun AddNewPlayerDialogPreview() {
    AfdTheme {
        AddNewPlayerDialog(
            onDismissRequest = {},
            onAddClicked = {}
        )
    }
}