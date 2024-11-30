package hu.nmth.afd.feature.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.AfdTransparent
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.TextNeutralSubtle
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.util.createGradientEffect

@Composable
fun PlayerBoardColumn(
    modifier: Modifier = Modifier,
    playerName: String,
    playerScores: List<Int>,
    isCurrentPlayer: Boolean,
    onPlayerSelected: () -> Unit
) {
    // LazyListState to control the scrolling
    val listState = rememberLazyListState()

    // Scroll to the latest item whenever the scores change
    LaunchedEffect(playerScores.size) {
        if (playerScores.isNotEmpty()) {
            listState.animateScrollToItem(playerScores.lastIndex)
        }
    }

    Column(
        modifier = gradientBackground(isSelected = isCurrentPlayer)
            .fillMaxHeight()
            .then(modifier)
            .clickable { onPlayerSelected() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Player name
        Column(
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.spacing300),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = playerName,
                color = TextBrandStrong,
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = Bold)
                    .takeIf { isCurrentPlayer }
                    ?: MaterialTheme.typography.titleLarge
            )
        }

        // Scroll list
        LazyColumn(
            state = listState,
            modifier = Modifier.padding(bottom = MaterialTheme.spacing.spacing200),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(playerScores) { index, score ->
                val isLastScore = index == playerScores.lastIndex

                Text(
                    text = score.toString(),
                    color = if (isLastScore) MainOrange else TextNeutralSubtle,
                    style = getScoreStyle(isLastScore)
                )
            }
        }
    }
}

@Composable
private fun getScoreStyle(isLastScore: Boolean): TextStyle {
    return if (isLastScore) {
        MaterialTheme.typography.titleLarge
    } else {
        MaterialTheme.typography.titleLarge.copy(textDecoration = TextDecoration.LineThrough)
    }
}

@Composable
private fun gradientBackground(isSelected: Boolean): Modifier {
    return if (isSelected) {
        Modifier.background(
            brush = createGradientEffect(
                colors = listOf(
                    MainOrange.copy(alpha = 0.2f),
                    AfdTransparent
                ),
                isVertical = true
            )
        )
    } else {
        Modifier.background(color = AfdTransparent)
    }
}

@Preview(showBackground = true)
@Composable
private fun PlayerBoardRowPreview() {
    PlayerBoardColumn(
        playerName = "Joseph",
        playerScores = listOf(5, 15, 25, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 100),
        isCurrentPlayer = true,
        onPlayerSelected = {}
    )
}