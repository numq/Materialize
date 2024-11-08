package generation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalClipboardManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun GenerationScreen(feature: GenerationFeature = koinInject()) {
    val coroutineScope = rememberCoroutineScope { Dispatchers.Default }

    val state by feature.state.collectAsState()

    val clipboardManager = LocalClipboardManager.current

    when (state) {
        is GenerationState.Loading -> GenerationScreenLoading()

        is GenerationState.Loaded -> with(state as GenerationState.Loaded) {
            GenerationScreenLoaded(
                formattedScheme = formattedScheme,
                lightPalette = scheme.lightPalette,
                darkPalette = scheme.darkPalette,
                selectedGenerationTab = selectedGenerationTab,
                selectGenerationTab = { generationTab ->
                    coroutineScope.launch {
                        feature.execute(
                            GenerationCommand.SelectGenerationTab(generationTab)
                        )
                    }
                },
                selectedLightPaletteColor = selectedLightPaletteColor,
                selectLightPaletteColor = { paletteColor ->
                    coroutineScope.launch {
                        feature.execute(
                            GenerationCommand.SelectLightPaletteColor(paletteColor)
                        )
                    }
                },
                selectedDarkPaletteColor = selectedDarkPaletteColor,
                selectDarkPaletteColor = { paletteColor ->
                    coroutineScope.launch {
                        feature.execute(
                            GenerationCommand.SelectDarkPaletteColor(paletteColor)
                        )
                    }
                },
                updateLightPaletteColor = { paletteColor, color ->
                    coroutineScope.launch {
                        feature.execute(
                            GenerationCommand.UpdateLightPaletteColor(paletteColor, color)
                        )
                    }
                },
                updateDarkPaletteColor = { paletteColor, color ->
                    coroutineScope.launch {
                        feature.execute(
                            GenerationCommand.UpdateDarkPaletteColor(paletteColor, color)
                        )
                    }
                },
                copyFormattedScheme = clipboardManager::setText
            )
        }
    }
}