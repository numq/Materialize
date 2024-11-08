package scheme

import palette.DarkPalette
import palette.LightPalette
import palette.PaletteColor

private fun intToArgbHex(argb: Int): String = String.format("%08X", argb)

private val defaultLightPalette = LightPalette(
    primary = PaletteColor.Primary(
        argb = 0xFF6200EE.toInt(),
        hex = intToArgbHex(0xFF6200EE.toInt()),
        name = "Deep Purple"
    ), primaryVariant = PaletteColor.PrimaryVariant(
        argb = 0xFF3700B3.toInt(),
        hex = intToArgbHex(0xFF3700B3.toInt()),
        name = "Dark Purple"
    ), secondary = PaletteColor.Secondary(
        argb = 0xFF03DAC6.toInt(),
        hex = intToArgbHex(0xFF03DAC6.toInt()),
        name = "Teal"
    ), secondaryVariant = PaletteColor.SecondaryVariant(
        argb = 0xFF018786.toInt(),
        hex = intToArgbHex(0xFF018786.toInt()),
        name = "Teal Dark"
    ), background = PaletteColor.Background(
        argb = 0xFFFFFFFF.toInt(),
        hex = intToArgbHex(0xFFFFFFFF.toInt()),
        name = "White"
    ), surface = PaletteColor.Surface(
        argb = 0xFFFFFFFF.toInt(),
        hex = intToArgbHex(0xFFFFFFFF.toInt()),
        name = "White"
    ), error = PaletteColor.Error(
        argb = 0xFFB00020.toInt(),
        hex = intToArgbHex(0xFFB00020.toInt()),
        name = "Red"
    ), onPrimary = PaletteColor.OnPrimary(
        argb = 0xFFFFFFFF.toInt(),
        hex = intToArgbHex(0xFFFFFFFF.toInt()),
        name = "White"
    ), onSecondary = PaletteColor.OnSecondary(
        argb = 0xFF000000.toInt(),
        hex = intToArgbHex(0xFF000000.toInt()),
        name = "Black"
    ), onBackground = PaletteColor.OnBackground(
        argb = 0xFF000000.toInt(),
        hex = intToArgbHex(0xFF000000.toInt()),
        name = "Black"
    ), onSurface = PaletteColor.OnSurface(
        argb = 0xFF000000.toInt(),
        hex = intToArgbHex(0xFF000000.toInt()),
        name = "Black"
    ), onError = PaletteColor.OnError(
        argb = 0xFFFFFFFF.toInt(),
        hex = intToArgbHex(0xFFFFFFFF.toInt()),
        name = "White"
    )
)

private val defaultDarkPalette = DarkPalette(
    primary = PaletteColor.Primary(
        argb = 0xFF6200EE.toInt(),
        hex = intToArgbHex(0xFF6200EE.toInt()),
        name = "Deep Purple"
    ), primaryVariant = PaletteColor.PrimaryVariant(
        argb = 0xFF3700B3.toInt(),
        hex = intToArgbHex(0xFF3700B3.toInt()),
        name = "Dark Purple"
    ), secondary = PaletteColor.Secondary(
        argb = 0xFF03DAC6.toInt(),
        hex = intToArgbHex(0xFF03DAC6.toInt()),
        name = "Teal"
    ), secondaryVariant = PaletteColor.SecondaryVariant(
        argb = 0xFF018786.toInt(),
        hex = intToArgbHex(0xFF018786.toInt()),
        name = "Teal Dark"
    ), background = PaletteColor.Background(
        argb = 0xFF121212.toInt(),
        hex = intToArgbHex(0xFF121212.toInt()),
        name = "Dark Background"
    ), surface = PaletteColor.Surface(
        argb = 0xFF121212.toInt(),
        hex = intToArgbHex(0xFF121212.toInt()),
        name = "Dark Surface"
    ), error = PaletteColor.Error(
        argb = 0xFFCF6679.toInt(),
        hex = intToArgbHex(0xFFCF6679.toInt()),
        name = "Light Red"
    ), onPrimary = PaletteColor.OnPrimary(
        argb = 0xFFFFFFFF.toInt(),
        hex = intToArgbHex(0xFFFFFFFF.toInt()),
        name = "White"
    ), onSecondary = PaletteColor.OnSecondary(
        argb = 0xFF000000.toInt(),
        hex = intToArgbHex(0xFF000000.toInt()),
        name = "Black"
    ), onBackground = PaletteColor.OnBackground(
        argb = 0xFFFFFFFF.toInt(),
        hex = intToArgbHex(0xFFFFFFFF.toInt()),
        name = "White"
    ), onSurface = PaletteColor.OnSurface(
        argb = 0xFFFFFFFF.toInt(),
        hex = intToArgbHex(0xFFFFFFFF.toInt()),
        name = "White"
    ), onError = PaletteColor.OnError(
        argb = 0xFF000000.toInt(),
        hex = intToArgbHex(0xFF000000.toInt()),
        name = "Black"
    )
)

val DefaultScheme = Scheme(
    lightPalette = defaultLightPalette, darkPalette = defaultDarkPalette
)