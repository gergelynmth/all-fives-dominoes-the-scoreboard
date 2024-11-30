package hu.nmth.afd.feature.game.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.icons.AfdIcons
import hu.nmth.afd.designsystem.theme.DividerNeutralSubtle
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.WhiteBackground
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing


@Composable
fun ScoreDisplay(
    modifier: Modifier = Modifier,
    score: String,
    onAddClicked: () -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing100)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Score
            Text(
                modifier = Modifier.padding(start = MaterialTheme.spacing.spacing1000),
                text = score,
                color = MainOrange,
                style = MaterialTheme.typography.displayMedium
            )

            // Next player button
            Button(
                shape = MaterialTheme.shape.rounded,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MainOrange,
                    contentColor = WhiteBackground
                ),
                onClick = onAddClicked
            ) {
                Icon(
                    painter = painterResource(id = AfdIcons.Add),
                    contentDescription = null,
                    tint = WhiteBackground
                )
            }
        }

        // Divider
        HorizontalDivider(
            modifier = Modifier.padding(horizontal = MaterialTheme.spacing.spacing300),
            thickness = MaterialTheme.spacing.spacing050,
            color = DividerNeutralSubtle
        )
    }
}

@Preview
@Composable
private fun ScoreDisplayPreview() {
    ScoreDisplay(
        score = "15",
        onAddClicked = {}
    )
}