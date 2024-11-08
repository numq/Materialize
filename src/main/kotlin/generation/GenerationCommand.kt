package generation

import androidx.compose.ui.graphics.Color
import palette.GenerationTab
import palette.PaletteColor
import scheme.Scheme

sealed interface GenerationCommand {
    data object InitializeScheme : GenerationCommand

    data class UpdateScheme(val scheme: Scheme) : GenerationCommand

    data class SelectGenerationTab(val generationTab: GenerationTab) : GenerationCommand

    data class SelectLightPaletteColor(val paletteColor: PaletteColor) : GenerationCommand

    data class SelectDarkPaletteColor(val paletteColor: PaletteColor) : GenerationCommand

    data class UpdateLightPaletteColor(val paletteColor: PaletteColor, val color: Color) : GenerationCommand

    data class UpdateDarkPaletteColor(val paletteColor: PaletteColor, val color: Color) : GenerationCommand
}