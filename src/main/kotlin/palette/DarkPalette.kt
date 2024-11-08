package palette

data class DarkPalette(
    override val primary: PaletteColor.Primary,
    override val primaryVariant: PaletteColor.PrimaryVariant,
    override val secondary: PaletteColor.Secondary,
    override val secondaryVariant: PaletteColor.SecondaryVariant,
    override val background: PaletteColor.Background,
    override val surface: PaletteColor.Surface,
    override val error: PaletteColor.Error,
    override val onPrimary: PaletteColor.OnPrimary,
    override val onSecondary: PaletteColor.OnSecondary,
    override val onBackground: PaletteColor.OnBackground,
    override val onSurface: PaletteColor.OnSurface,
    override val onError: PaletteColor.OnError,
) : Palette