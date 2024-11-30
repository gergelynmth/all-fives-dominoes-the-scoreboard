package hu.nmth.afd.designsystem.util

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.NonRestartableComposable
import androidx.compose.ui.unit.Dp

val WindowInsets.Companion.statusBarHeight: Dp
    @Composable
    @NonRestartableComposable
    get() = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()