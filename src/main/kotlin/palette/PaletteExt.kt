package palette

val Palette.colors: List<PaletteColor>
    get() = listOf(
        primary,
        primaryVariant,
        secondary,
        secondaryVariant,
        background,
        surface,
        error,
        onPrimary,
        onSecondary,
        onBackground,
        onSurface,
        onError
    )