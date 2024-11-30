package hu.nmth.afd.designsystem.ui.components.dialogs

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import hu.nmth.afd.designsystem.theme.BackgroundNeutral
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing

@Composable
fun AfdDialog(
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit,
    content: @Composable () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            modifier =
            modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(
                    horizontal = MaterialTheme.spacing.spacing400,
                )
                .border(
                    border = BorderStroke(MaterialTheme.spacing.spacing025, color = MainOrange),
                    shape = MaterialTheme.shape.radius400
                ),
            shape = MaterialTheme.shape.radius400,
            color = BackgroundNeutral,
            tonalElevation = AlertDialogDefaults.TonalElevation
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(MaterialTheme.shape.radius400)
                    .padding(MaterialTheme.spacing.spacing200),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing400)
            ) {
                content()
            }
        }
    }
}