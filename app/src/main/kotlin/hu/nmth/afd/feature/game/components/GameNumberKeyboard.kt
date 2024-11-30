package hu.nmth.afd.feature.game.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.icons.AfdIcons
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.spacing

@Composable
fun GameNumberKeyboard(
    modifier: Modifier = Modifier,
    onNumberClicked: (String) -> Unit,
    onDeleteClicked: () -> Unit
) {
    Column(
        modifier = modifier.padding(horizontal = MaterialTheme.spacing.spacing400),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing200)
    ) {
        // 7, 8, 9
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing1200)
        ) {

            NumberButton(
                number = 7,
                onClick = { onNumberClicked(it.toString()) }
            )

            NumberButton(
                number = 8,
                onClick = { onNumberClicked(it.toString()) }
            )

            NumberButton(
                number = 9,
                onClick = { onNumberClicked(it.toString()) }
            )

        }

        // 4, 5, 6
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing1200)
        ) {
            NumberButton(
                number = 4,
                onClick = { onNumberClicked(it.toString()) }
            )
            NumberButton(
                number = 5,
                onClick = { onNumberClicked(it.toString()) }
            )
            NumberButton(
                number = 6,
                onClick = { onNumberClicked(it.toString()) }
            )
        }

        // 1, 2, 3
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(
                MaterialTheme.spacing.spacing1200,
                Alignment.CenterHorizontally
            )
        ) {
            NumberButton(
                number = 1,
                onClick = { onNumberClicked(it.toString()) }
            )
            NumberButton(
                number = 2,
                onClick = { onNumberClicked(it.toString()) }
            )
            NumberButton(
                number = 3,
                onClick = { onNumberClicked(it.toString()) }
            )
        }

        // 0, delete
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing1200)
        ) {
            NumberButton(
                number = 0,
                onClick = { onNumberClicked(it.toString()) }
            )

            IconButton(
                modifier = Modifier.size(MaterialTheme.spacing.spacing1600),
                onClick = { onDeleteClicked() }
            ) {
                Icon(
                    painter = painterResource(id = AfdIcons.BackSpace),
                    contentDescription = null,
                    tint = TextBrandStrong
                )
            }
        }
    }
}

@Preview
@Composable
private fun GameNumberKeyboardPreview() {
    GameNumberKeyboard(
        onNumberClicked = {},
        onDeleteClicked = {}
    )
}

