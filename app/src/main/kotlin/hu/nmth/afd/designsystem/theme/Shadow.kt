package hu.nmth.afd.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

data class Shadow(
    val color: Color = Color.Black,
    val blurRadius: Dp = 0.dp,
    val spreadRadius: Dp = 0.dp,
    val offset: DpOffset = DpOffset.Zero,
    val inset: Boolean = false,
)

@Immutable
data class Shadows(
    val shadowMd7: Shadow =
        Shadow(
            color = NeutralStrong.copy(0.07f),
            offset = DpOffset(x = 2.dp, y = 2.dp),
            blurRadius = 8.dp
        ),
    val shadowLg7: Shadow =
        Shadow(
            color = NeutralStrong.copy(0.07f),
            offset = DpOffset(x = 2.dp, y = 2.dp),
            blurRadius = 24.dp
        ),
    val shadowMd15: Shadow =
        Shadow(
            color = NeutralStrong.copy(0.15f),
            offset = DpOffset(x = 2.dp, y = 2.dp),
            blurRadius = 8.dp
        ),
    val shadowLg15: Shadow =
        Shadow(
            color = NeutralStrong.copy(0.15f),
            offset = DpOffset(x = 2.dp, y = 2.dp),
            blurRadius = 24.dp
        ),
)

val LocalShadows = compositionLocalOf { Shadows() }

val MaterialTheme.shadows: Shadows
    @Composable @ReadOnlyComposable get() = LocalShadows.current
