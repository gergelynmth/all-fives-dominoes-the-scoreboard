package hu.nmth.afd.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class Shape(
    val radius0: RoundedCornerShape = RoundedCornerShape(0.dp),
    val radius050: RoundedCornerShape = RoundedCornerShape(2.dp),
    val radius100: RoundedCornerShape = RoundedCornerShape(4.dp),
    val radius200: RoundedCornerShape = RoundedCornerShape(8.dp),
    val radius300: RoundedCornerShape = RoundedCornerShape(12.dp),
    val radius400: RoundedCornerShape = RoundedCornerShape(16.dp),
    val rounded: RoundedCornerShape = RoundedCornerShape(100.dp),
    val bottomSheetShape: RoundedCornerShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    val segmentedControlRoundedShape: RoundedCornerShape = RoundedCornerShape(11.dp),
)

val LocalShape = compositionLocalOf { Shape() }

val MaterialTheme.shape: Shape
    @Composable @ReadOnlyComposable get() = LocalShape.current
