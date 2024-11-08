package scheme

import interactor.Interactor
import palette.Palette
import palette.PaletteColor

class UpdateScheme(private val schemeRepository: SchemeRepository) : Interactor<UpdateScheme.Input, Unit> {
    data class Input(val palette: Palette, val paletteColor: PaletteColor, val argb: Int)

    override suspend fun execute(input: Input) = with(input) {
        schemeRepository.updateSchemePaletteColor(palette = palette, paletteColor = paletteColor, argb = argb)
    }
}