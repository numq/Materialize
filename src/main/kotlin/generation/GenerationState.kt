package generation

import palette.GenerationTab
import palette.PaletteColor
import scheme.Scheme

sealed interface GenerationState {
    data object Loading : GenerationState

    data class Loaded(
        val scheme: Scheme,
        val formattedScheme: String,
        val selectedGenerationTab: GenerationTab,
        val selectedLightPaletteColor: PaletteColor,
        val selectedDarkPaletteColor: PaletteColor,
    ) : GenerationState
}