package palette

interface Palette {
    val primary: PaletteColor.Primary
    val primaryVariant: PaletteColor.PrimaryVariant
    val secondary: PaletteColor.Secondary
    val secondaryVariant: PaletteColor.SecondaryVariant
    val background: PaletteColor.Background
    val surface: PaletteColor.Surface
    val error: PaletteColor.Error
    val onPrimary: PaletteColor.OnPrimary
    val onSecondary: PaletteColor.OnSecondary
    val onBackground: PaletteColor.OnBackground
    val onSurface: PaletteColor.OnSurface
    val onError: PaletteColor.OnError
}