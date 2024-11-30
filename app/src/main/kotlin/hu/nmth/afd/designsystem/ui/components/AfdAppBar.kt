package hu.nmth.afd.designsystem.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.util.statusBarHeight

@Composable
fun AfdAppBar(
    modifier: Modifier = Modifier,
    title: String,
    tailingIcon: @Composable (() -> Unit)? = null,
) {
    val height =
        WindowInsets.statusBarHeight + MaterialTheme.spacing.spacing1200
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(MainOrange)
            .height(height)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(MaterialTheme.spacing.spacing1400)
                .padding(top = WindowInsets.statusBarHeight),
        ) {
            Text(
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(top = MaterialTheme.spacing.spacing200),
                text = title,
                style = MaterialTheme.typography.titleMedium,
            )

            tailingIcon?.let {
                Box(
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .clip(MaterialTheme.shape.rounded)
                        .padding(top = MaterialTheme.spacing.spacing200),
                ) {
                    tailingIcon()
                }
            }
        }
    }
}


@Preview
@Composable
private fun HomeAppBarPreview() {
    AfdTheme {
        AfdAppBar(
            title = "Title"
        )
    }
}