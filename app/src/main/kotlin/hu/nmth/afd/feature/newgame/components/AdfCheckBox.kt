package hu.nmth.afd.feature.newgame.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.TextNegative
import hu.nmth.afd.designsystem.theme.NeutralSubtle
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing

@Composable
fun AdfCheckBox(modifier: Modifier = Modifier, checked: Boolean, error: Boolean = false) {
    val color =
        TextNegative.takeIf { error }
            ?: MainOrange.takeIf { checked }
            ?: NeutralSubtle

    val borderWidth =
        MaterialTheme.spacing.spacing100.takeIf { checked && !error }
            ?: MaterialTheme.spacing.spacing050

    Box(
        modifier =
        modifier
            .size(MaterialTheme.spacing.spacing600)
            .padding(MaterialTheme.spacing.spacing050)
            .clip(MaterialTheme.shape.rounded)
            .border(BorderStroke(borderWidth, color), shape = MaterialTheme.shape.rounded)
    )
}

@Preview
@Composable
private fun AdfCheckBoxPreview(
    checked: Boolean = true
) {
    AdfCheckBox(checked = checked)
}