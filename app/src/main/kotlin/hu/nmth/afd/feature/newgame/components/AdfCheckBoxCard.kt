package hu.nmth.afd.feature.newgame.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.AfdTransparent
import hu.nmth.afd.designsystem.theme.BackgroundNeutralSubtle
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.NeutralStrong
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.TextWhite
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing

@Composable
fun AdfCheckBoxCard(
    modifier: Modifier = Modifier,
    label: String,
    checked: Boolean,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(MaterialTheme.shape.radius400)
            .background(MainOrange.takeIf { checked } ?: BackgroundNeutralSubtle)
            .clickable { onClick() },
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(MaterialTheme.spacing.spacing300),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing300)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth().padding(start = MaterialTheme.spacing.spacing400),
                text = label,
                style = MaterialTheme.typography.titleMedium,
                color = TextWhite.takeIf { checked } ?: TextBrandStrong,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
private fun AdfCheckBoxCardPreview(
    label: String = "Label",
    checked: Boolean = false
) {
    AdfCheckBoxCard(
        label = label,
        checked = checked,
        onClick = {}
    )
}