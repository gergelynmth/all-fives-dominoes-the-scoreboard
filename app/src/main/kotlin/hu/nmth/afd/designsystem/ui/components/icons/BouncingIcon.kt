package hu.nmth.afd.designsystem.ui.components.icons

import android.annotation.SuppressLint
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import kotlinx.coroutines.delay

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun BouncingIcon(
    modifier: Modifier = Modifier,
    painter: Painter
) {
    // State to control the vertical position
    var offsetY by remember { mutableStateOf(0.dp) }

    // Infinite transition for smooth up-and-down animation
    val animatedOffset by animateDpAsState(
        targetValue = offsetY,
        animationSpec = tween(durationMillis = 1000, easing = LinearEasing), label = ""
    )

    // Loop the animation using LaunchedEffect
    LaunchedEffect(Unit) {
        while (true) {
            offsetY = 8.dp // Move down
            delay(500)
            offsetY = 0.dp // Move back up
            delay(500)
        }
    }

    Icon(
        modifier = modifier.offset(y = animatedOffset),
        painter = painter,
        contentDescription = null,
        tint = TextBrandStrong
    )
}
