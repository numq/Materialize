package scheme

import formatter.FormatterService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import name.NameService
import palette.DarkPalette
import palette.LightPalette
import palette.Palette
import palette.PaletteColor

interface SchemeRepository {
    val scheme: StateFlow<Scheme>
    suspend fun updateSchemePaletteColor(palette: Palette, paletteColor: PaletteColor, argb: Int): Result<Unit>
    suspend fun formatScheme(scheme: Scheme): Result<String>

    class Default(
        private val nameService: NameService,
        private val formatterService: FormatterService,
    ) : SchemeRepository {
        override var scheme = MutableStateFlow(DefaultScheme)

        override suspend fun updateSchemePaletteColor(
            palette: Palette,
            paletteColor: PaletteColor,
            argb: Int,
        ) = runCatching {
            String.format("#%08X", argb).let { hex ->
                when (palette) {
                    is LightPalette -> scheme.emit(
                        scheme.value.copy(
                            lightPalette = when (paletteColor) {
                                is PaletteColor.Primary -> palette.copy(
                                    primary = PaletteColor.Primary(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.PrimaryVariant -> palette.copy(
                                    primaryVariant = PaletteColor.PrimaryVariant(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.Secondary -> palette.copy(
                                    secondary = PaletteColor.Secondary(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.SecondaryVariant -> palette.copy(
                                    secondaryVariant = PaletteColor.SecondaryVariant(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.Background -> palette.copy(
                                    background = PaletteColor.Background(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.Surface -> palette.copy(
                                    surface = PaletteColor.Surface(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.Error -> palette.copy(
                                    error = PaletteColor.Error(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnPrimary -> palette.copy(
                                    onPrimary = PaletteColor.OnPrimary(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnSecondary -> palette.copy(
                                    onSecondary = PaletteColor.OnSecondary(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnBackground -> palette.copy(
                                    onBackground = PaletteColor.OnBackground(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnSurface -> palette.copy(
                                    onSurface = PaletteColor.OnSurface(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnError -> palette.copy(
                                    onError = PaletteColor.OnError(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )
                            }
                        )
                    )

                    is DarkPalette -> scheme.emit(
                        scheme.value.copy(
                            darkPalette = when (paletteColor) {
                                is PaletteColor.Primary -> palette.copy(
                                    primary = PaletteColor.Primary(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.PrimaryVariant -> palette.copy(
                                    primaryVariant = PaletteColor.PrimaryVariant(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.Secondary -> palette.copy(
                                    secondary = PaletteColor.Secondary(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.SecondaryVariant -> palette.copy(
                                    secondaryVariant = PaletteColor.SecondaryVariant(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.Background -> palette.copy(
                                    background = PaletteColor.Background(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.Surface -> palette.copy(
                                    surface = PaletteColor.Surface(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.Error -> palette.copy(
                                    error = PaletteColor.Error(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnPrimary -> palette.copy(
                                    onPrimary = PaletteColor.OnPrimary(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnSecondary -> palette.copy(
                                    onSecondary = PaletteColor.OnSecondary(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnBackground -> palette.copy(
                                    onBackground = PaletteColor.OnBackground(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnSurface -> palette.copy(
                                    onSurface = PaletteColor.OnSurface(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )

                                is PaletteColor.OnError -> palette.copy(
                                    onError = PaletteColor.OnError(
                                        argb = argb,
                                        hex = hex,
                                        name = nameService.getName(argb = argb).getOrThrow()
                                    )
                                )
                            }
                        )
                    )
                }
            }
        }

        override suspend fun formatScheme(scheme: Scheme) = formatterService.formatScheme(scheme)
    }
}