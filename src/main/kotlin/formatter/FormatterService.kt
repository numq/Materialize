package formatter

import name.NameService
import palette.PaletteColor
import palette.colors
import scheme.Scheme

interface FormatterService {
    fun formatScheme(scheme: Scheme): Result<String>

    class Default(private val nameService: NameService) : FormatterService {

        private fun formatColors(colors: List<PaletteColor>) = runCatching {
            colors.joinToString("\n") { color ->
                val colorNameComment = nameService.getName(color.argb).getOrThrow()?.let { " // $it" } ?: ""
                "   ${color.type} = Color(0x${color.hex}),${colorNameComment}"
            }
        }

        override fun formatScheme(scheme: Scheme) = runCatching {
            val lightColors =
                "internal val LightColors = lightColors(\n${formatColors(scheme.lightPalette.colors).getOrThrow()}\n)"

            val darkColors =
                "internal val DarkColors = darkColors(\n${formatColors(scheme.darkPalette.colors).getOrThrow()}\n)"

            "$lightColors\n\n$darkColors"
        }
    }
}