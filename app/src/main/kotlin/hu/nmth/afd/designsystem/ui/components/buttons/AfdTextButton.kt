package hu.nmth.afd.designsystem.ui.components.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.icons.AfdIcons
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.spacing

@Composable
fun AfdTextButton(
    modifier: Modifier = Modifier,
    label: String,
    headingIcon: Painter,
    onClick: () -> Unit
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        contentPadding = PaddingValues(MaterialTheme.spacing.spacing050)
    ) {
        Icon(
            painter = headingIcon,
            contentDescription = null,
            tint = TextBrandStrong
        )

        Text(
            text = label,
            style = MaterialTheme.typography.titleSmall,
            color = TextBrandStrong
        )
    }
}

@Preview
@Composable
private fun AdfTextButtonPreview(
    label: String = "label",
    headingIcon: Painter = painterResource(id = AfdIcons.Add)
) {
    AfdTheme {
        AfdTextButton(
            label = label,
            headingIcon = headingIcon,
            onClick = {},
        )
    }
}