package hu.nmth.afd.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class Spacing(
    val spacing0: Dp = 0.dp,
    val spacing025: Dp = 1.dp,
    val spacing050: Dp = 2.dp,
    val spacing075: Dp = 3.dp,
    val spacing100: Dp = 4.dp,
    val spacing150: Dp = 6.dp,
    val spacing200: Dp = 8.dp,
    val spacing300: Dp = 12.dp,
    val spacing350: Dp = 10.dp,
    val spacing400: Dp = 16.dp,
    val spacing500: Dp = 20.dp,
    val spacing600: Dp = 24.dp,
    val spacing700: Dp = 28.dp,
    val spacing800: Dp = 32.dp,
    val spacing900: Dp = 36.dp,
    val spacing1000: Dp = 40.dp,
    val spacing1200: Dp = 48.dp,
    val spacing1400: Dp = 56.dp,
    val spacing1600: Dp = 64.dp,
    val spacing1800: Dp = 72.dp,
    val spacing2000: Dp = 80.dp,
    val spacing2400: Dp = 96.dp,
    val spacing3200: Dp = 128.dp,
)

val LocalSpacing = compositionLocalOf { Spacing() }

val MaterialTheme.spacing: Spacing
    @Composable @ReadOnlyComposable get() = LocalSpacing.current
