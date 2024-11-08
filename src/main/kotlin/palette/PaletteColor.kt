package palette

sealed interface PaletteColor {
    val type: String
    val argb: Int
    val hex: String
    val name: String?

    data class Primary(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "primary"
    }

    data class PrimaryVariant(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "primaryVariant"
    }

    data class Secondary(
        override val argb:
        Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "secondary"
    }

    data class SecondaryVariant(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "secondaryVariant"
    }

    data class Background(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "background"
    }

    data class Surface(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "surface"
    }

    data class Error(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "error"
    }

    data class OnPrimary(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "onPrimary"
    }

    data class OnSecondary(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "onSecondary"
    }

    data class OnBackground(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "onBackground"
    }

    data class OnSurface(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "onSurface"
    }

    data class OnError(
        override val argb: Int,
        override val hex: String,
        override val name: String?,
    ) : PaletteColor {
        override val type: String
            get() = "onError"
    }
}