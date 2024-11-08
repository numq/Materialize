package palette

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

fun Palette.toLightColors() = lightColors(
    primary = Color(primary.argb),
    primaryVariant = Color(primaryVariant.argb),
    secondary = Color(secondary.argb),
    secondaryVariant = Color(secondaryVariant.argb),
    background = Color(background.argb),
    surface = Color(surface.argb),
    error = Color(error.argb),
    onPrimary = Color(onPrimary.argb),
    onSecondary = Color(onSecondary.argb),
    onBackground = Color(onBackground.argb),
    onSurface = Color(onSurface.argb),
    onError = Color(onError.argb)
)

fun Palette.toDarkColors() = darkColors(
    primary = Color(primary.argb),
    primaryVariant = Color(primaryVariant.argb),
    secondary = Color(secondary.argb),
    secondaryVariant = Color(secondaryVariant.argb),
    background = Color(background.argb),
    surface = Color(surface.argb),
    error = Color(error.argb),
    onPrimary = Color(onPrimary.argb),
    onSecondary = Color(onSecondary.argb),
    onBackground = Color(onBackground.argb),
    onSurface = Color(onSurface.argb),
    onError = Color(onError.argb)
)