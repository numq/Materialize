package generation

import androidx.compose.ui.graphics.toArgb
import feature.Reducer
import palette.GenerationTab
import palette.PaletteColor
import scheme.FormatScheme
import scheme.GetScheme
import scheme.UpdateScheme

class GenerationReducer(
    private val getScheme: GetScheme,
    private val formatScheme: FormatScheme,
    private val updateScheme: UpdateScheme,
) : Reducer<GenerationCommand, GenerationState, GenerationEvent> {
    override suspend fun reduce(
        state: GenerationState,
        command: GenerationCommand,
    ) = when (command) {
        is GenerationCommand.InitializeScheme -> when (state) {
            is GenerationState.Loading -> getScheme.execute(input = Unit).mapCatching { schemeFlow ->
                transition(state, GenerationEvent.SchemeUpdates(schemeFlow = schemeFlow))
            }.getOrElse { t ->
                transition(state, GenerationEvent.Error(Exception(t)))
            }

            is GenerationState.Loaded -> transition(state)
        }

        is GenerationCommand.UpdateScheme -> command.scheme.let { scheme ->
            formatScheme.execute(input = command.scheme).mapCatching { formattedScheme ->
                when (state) {
                    is GenerationState.Loading -> transition(
                        GenerationState.Loaded(
                            scheme = scheme,
                            formattedScheme = formattedScheme,
                            selectedGenerationTab = GenerationTab.LIGHT_PALETTE,
                            selectedLightPaletteColor = scheme.lightPalette.primary,
                            selectedDarkPaletteColor = scheme.darkPalette.primary
                        )
                    )

                    is GenerationState.Loaded -> transition(
                        state.copy(
                            scheme = scheme,
                            formattedScheme = formattedScheme,
                            selectedLightPaletteColor = when (state.selectedLightPaletteColor) {
                                is PaletteColor.Primary -> scheme.lightPalette.primary

                                is PaletteColor.PrimaryVariant -> scheme.lightPalette.primaryVariant

                                is PaletteColor.Secondary -> scheme.lightPalette.secondary

                                is PaletteColor.SecondaryVariant -> scheme.lightPalette.secondaryVariant

                                is PaletteColor.Background -> scheme.lightPalette.background

                                is PaletteColor.Surface -> scheme.lightPalette.surface

                                is PaletteColor.Error -> scheme.lightPalette.error

                                is PaletteColor.OnPrimary -> scheme.lightPalette.onPrimary

                                is PaletteColor.OnSecondary -> scheme.lightPalette.onSecondary

                                is PaletteColor.OnBackground -> scheme.lightPalette.onBackground

                                is PaletteColor.OnSurface -> scheme.lightPalette.onSurface

                                is PaletteColor.OnError -> scheme.lightPalette.onError
                            },
                            selectedDarkPaletteColor = when (state.selectedDarkPaletteColor) {
                                is PaletteColor.Primary -> scheme.darkPalette.primary

                                is PaletteColor.PrimaryVariant -> scheme.darkPalette.primaryVariant

                                is PaletteColor.Secondary -> scheme.darkPalette.secondary

                                is PaletteColor.SecondaryVariant -> scheme.darkPalette.secondaryVariant

                                is PaletteColor.Background -> scheme.darkPalette.background

                                is PaletteColor.Surface -> scheme.darkPalette.surface

                                is PaletteColor.Error -> scheme.darkPalette.error

                                is PaletteColor.OnPrimary -> scheme.darkPalette.onPrimary

                                is PaletteColor.OnSecondary -> scheme.darkPalette.onSecondary

                                is PaletteColor.OnBackground -> scheme.darkPalette.onBackground

                                is PaletteColor.OnSurface -> scheme.darkPalette.onSurface

                                is PaletteColor.OnError -> scheme.darkPalette.onError
                            }
                        )
                    )
                }
            }.getOrElse { t ->
                transition(state, GenerationEvent.Error(Exception(t)))
            }
        }

        is GenerationCommand.SelectGenerationTab -> when (state) {
            is GenerationState.Loading -> transition(state)

            is GenerationState.Loaded -> transition(state.copy(selectedGenerationTab = command.generationTab))
        }

        is GenerationCommand.SelectLightPaletteColor -> when (state) {
            is GenerationState.Loading -> transition(state)

            is GenerationState.Loaded -> transition(state.copy(selectedLightPaletteColor = command.paletteColor))
        }

        is GenerationCommand.SelectDarkPaletteColor -> when (state) {
            is GenerationState.Loading -> transition(state)

            is GenerationState.Loaded -> transition(state.copy(selectedDarkPaletteColor = command.paletteColor))
        }

        is GenerationCommand.UpdateLightPaletteColor -> when (state) {
            is GenerationState.Loading -> transition(state)

            is GenerationState.Loaded -> updateScheme.execute(
                input = UpdateScheme.Input(
                    palette = state.scheme.lightPalette,
                    paletteColor = command.paletteColor,
                    argb = command.color.toArgb()
                )
            ).fold(onSuccess = {
                transition(state)
            }, onFailure = { t ->
                transition(state, GenerationEvent.Error(Exception(t)))
            })
        }

        is GenerationCommand.UpdateDarkPaletteColor -> when (state) {
            is GenerationState.Loading -> transition(state)

            is GenerationState.Loaded -> updateScheme.execute(
                input = UpdateScheme.Input(
                    palette = state.scheme.darkPalette,
                    paletteColor = command.paletteColor,
                    argb = command.color.toArgb()
                )
            ).fold(onSuccess = {
                transition(state)
            }, onFailure = { t ->
                transition(state, GenerationEvent.Error(Exception(t)))
            })
        }
    }
}