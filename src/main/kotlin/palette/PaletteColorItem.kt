package palette

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.TooltipArea
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PaletteColorItem(
    paletteColor: PaletteColor,
    isSelected: Boolean,
    select: (PaletteColor) -> Unit,
) {
    Card(modifier = Modifier.padding(horizontal = if (isSelected) 4.dp else 0.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth().clickable(enabled = !isSelected, onClick = {
                select(paletteColor)
            }).padding(4.dp),
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(paletteColor.type, modifier = Modifier.weight(1f))
            TooltipArea(tooltip = {
                Card {
                    Row(
                        modifier = Modifier.padding(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text("#${paletteColor.hex}")
                        Text(paletteColor.name ?: "Unspecified")
                    }
                }
            }) {
                Box(
                    modifier = Modifier.size(16.dp).background(Color(paletteColor.argb))
                )
            }
        }
    }
}