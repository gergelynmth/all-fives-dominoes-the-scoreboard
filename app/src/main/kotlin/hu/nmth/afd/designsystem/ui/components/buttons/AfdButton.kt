package hu.nmth.afd.designsystem.ui.components.buttons

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.AfdTransparent
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.TextNegative
import hu.nmth.afd.designsystem.theme.SecondaryOrange
import hu.nmth.afd.designsystem.theme.WhiteBackground
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing

enum class AfdButtonStyle {
    PRIMARY,
    SECONDARY,
    NEGATIVE;

    internal val background: Color
        @Composable
        get() =
            when (this) {
                PRIMARY -> MainOrange
                SECONDARY -> SecondaryOrange
                NEGATIVE -> AfdTransparent
            }

    internal val textColor: Color
        @Composable
        get() =
            when (this) {
                PRIMARY -> WhiteBackground
                SECONDARY -> WhiteBackground
                NEGATIVE -> TextNegative
            }
}

@Composable
fun AfdButton(
    modifier: Modifier = Modifier,
    label: String,
    style: AfdButtonStyle = AfdButtonStyle.PRIMARY,
    enabled: Boolean = true,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }

    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shape.rounded,
        colors = ButtonDefaults.buttonColors(
            containerColor = style.background,
            contentColor = style.textColor
        ),
        enabled = enabled,
        interactionSource = interactionSource,
    ) {
        Text(
            modifier = Modifier.padding(vertical = MaterialTheme.spacing.spacing100),
            text = label,
            style = MaterialTheme.typography.titleLarge
        )
    }
}

@Preview
@Composable
private fun AfdButtonPreview(
    label: String = "Label",
    style: AfdButtonStyle = AfdButtonStyle.PRIMARY
) {
    AfdTheme {
        AfdButton(
            label = label,
            style = style,
            onClick = {},
        )
    }
}