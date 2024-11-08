package palette

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PaletteColors(
    palette: Palette,
    selectedPaletteColor: PaletteColor,
    selectColor: (PaletteColor) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(palette.colors) { paletteColor ->
            PaletteColorItem(
                paletteColor = paletteColor,
                isSelected = paletteColor == selectedPaletteColor,
                select = selectColor
            )
        }
    }
}