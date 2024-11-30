package hu.nmth.afd.feature.game.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.headlineSmallBold
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing

@Composable
fun NumberButton(modifier: Modifier = Modifier, number: Int, onClick: (Int) -> Unit) {
    Box(
        modifier = modifier
            .size(MaterialTheme.spacing.spacing1600)
            .clip(MaterialTheme.shape.rounded)
            .clickable { onClick(number) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = number.toString(),
            style = MaterialTheme.typography.headlineSmallBold,
            color = TextBrandStrong
        )
    }
}

@Preview
@Composable
private fun NumberButtonPreview() {
    AfdTheme {
        NumberButton(
            number = 1,
            onClick = {}
        )
    }
}