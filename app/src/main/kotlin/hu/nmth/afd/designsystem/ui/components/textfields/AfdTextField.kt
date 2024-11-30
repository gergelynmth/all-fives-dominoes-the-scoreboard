package hu.nmth.afd.designsystem.ui.components.textfields

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hu.nmth.afd.designsystem.theme.AfdTheme
import hu.nmth.afd.designsystem.theme.AfdTransparent
import hu.nmth.afd.designsystem.theme.BackgroundNeutralSubtle
import hu.nmth.afd.designsystem.theme.MainOrange
import hu.nmth.afd.designsystem.theme.NeutralSubtle
import hu.nmth.afd.designsystem.theme.TextBrandStrong
import hu.nmth.afd.designsystem.theme.TextNegative
import hu.nmth.afd.designsystem.theme.shape
import hu.nmth.afd.designsystem.theme.spacing

@Composable
fun AfdTextField(
    modifier: Modifier = Modifier,
    text: String = "",
    onTextChange: (String) -> Unit,
    placeholder: String? = null,
    feedback: String? = null,
    maxCharacters: Int = Int.MAX_VALUE
) {
    var textValue by remember(key1 = text) { mutableStateOf(text) }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.spacing.spacing100)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = textValue,
            onValueChange = { newValue ->
                textValue = newValue.take(maxCharacters)
                onTextChange(textValue)
            },
            singleLine = true,
            shape = MaterialTheme.shape.radius400,
            placeholder = {
                placeholder?.let {
                    Text(
                        text = placeholder,
                        color = NeutralSubtle
                    )
                }
            },
            textStyle = MaterialTheme.typography.bodyLarge,
            maxLines = 1,
            colors =
            OutlinedTextFieldDefaults.colors(
                unfocusedContainerColor = BackgroundNeutralSubtle,
                focusedContainerColor = BackgroundNeutralSubtle,
                focusedBorderColor = MainOrange,
                focusedTextColor = TextBrandStrong,
                unfocusedBorderColor = AfdTransparent,
                cursorColor = MainOrange
            )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.spacing.spacing200),
            horizontalArrangement =
            Arrangement.End
                .takeIf { feedback == null }
                ?: Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Feedback
            feedback?.let {
                Text(
                    text = feedback,
                    color = TextNegative,
                    style = MaterialTheme.typography.labelSmall
                )
            }

            // Character counter
            Text(
                text = "(${textValue.length} / $maxCharacters)",
                color = TextBrandStrong,
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview
@Composable
internal fun AfdTextFieldPreview(
    text: String = "",
    placeholder: String? = "Placeholder",
    feedback: String? = null
) {
    AfdTheme {
        AfdTextField(
            text = text,
            onTextChange = {},
            placeholder = placeholder,
            feedback = feedback
        )
    }
}