package hu.nmth.afd.designsystem.ui.components.dialogs

import android.view.Gravity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import hu.nmth.afd.R
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.NeutralStrong
import hu.nmth.afd.designsystem.theme.NeutralSubtle
import hu.nmth.afd.designsystem.theme.WhiteBackground
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing
import hu.nmth.afd.designsystem.util.getDialogWindow
import hu.nmth.afd.designsystem.ui.components.buttons.AfdButton

@Composable
fun WarningDialog(
    onDismissRequest: () -> Unit,
    title: String,
    description: String
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(usePlatformDefaultWidth = false),
    ) {
        getDialogWindow()?.setGravity(Gravity.BOTTOM)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clip(MaterialTheme.shape.radius400)
                .background(WhiteBackground)
                .padding(MaterialTheme.spacing.spacing200),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing400)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                style = MaterialTheme.typography.headlineLarge,
                color = NeutralStrong,
                textAlign = TextAlign.Center
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = description,
                style = MaterialTheme.typography.headlineSmall,
                color = NeutralSubtle,
                textAlign = TextAlign.Center
            )

            AfdButton(
                label = stringResource(R.string.button_okay),
                onClick = onDismissRequest
            )
        }
    }
}

@Preview
@Composable
private fun WarningDialogPreview() {
    AfdTheme {
        WarningDialog(
            onDismissRequest = {},
            title = "Title",
            description = "Lorem ipsum, lorem ipsum!"
        )
    }
}

