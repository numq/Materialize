package generation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ContentCopy
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.unit.dp
import com.github.numq.composecolorpicker.picker.rectangular.RectangularColorPicker
import com.github.numq.composesplitscreen.HorizontalSplitScreen
import palette.*
import preview.Preview

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GenerationScreenLoaded(
    formattedScheme: String,
    lightPalette: LightPalette,
    darkPalette: DarkPalette,
    selectedGenerationTab: GenerationTab,
    selectGenerationTab: (GenerationTab) -> Unit,
    selectedLightPaletteColor: PaletteColor,
    selectLightPaletteColor: (PaletteColor) -> Unit,
    selectedDarkPaletteColor: PaletteColor,
    selectDarkPaletteColor: (PaletteColor) -> Unit,
    updateLightPaletteColor: (PaletteColor, Color) -> Unit,
    updateDarkPaletteColor: (PaletteColor, Color) -> Unit,
    copyFormattedScheme: (AnnotatedString) -> Unit,
) {
    val formattedSchemeScrollState = rememberScrollState(0)

    HorizontalSplitScreen(
        modifier = Modifier.fillMaxSize(),
        minSliderPercentage = .25f,
        maxSliderPercentage = .75f,
        left = {
            MaterialTheme(
                colors = when (selectedGenerationTab) {
                    GenerationTab.LIGHT_PALETTE -> lightPalette.toLightColors()

                    GenerationTab.DARK_PALETTE -> darkPalette.toDarkColors()
                }
            ) {
                Preview()
            }
        },
        right = {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.CenterVertically)
            ) {
                TabRow(
                    selectedTabIndex = selectedGenerationTab.ordinal, modifier = Modifier.fillMaxWidth()
                ) {
                    Tab(modifier = Modifier.background(Color.Black).padding(4.dp),
                        selected = selectedGenerationTab == GenerationTab.LIGHT_PALETTE,
                        enabled = selectedGenerationTab != GenerationTab.LIGHT_PALETTE,
                        onClick = {
                            selectGenerationTab(GenerationTab.LIGHT_PALETTE)
                        }) {
                        Icon(Icons.Default.LightMode, null, tint = Color.White)
                    }
                    Tab(modifier = Modifier.background(Color.Black).padding(4.dp),
                        selected = selectedGenerationTab == GenerationTab.DARK_PALETTE,
                        enabled = selectedGenerationTab != GenerationTab.DARK_PALETTE,
                        onClick = {
                            selectGenerationTab(GenerationTab.DARK_PALETTE)
                        }) {
                        Icon(Icons.Default.DarkMode, null, tint = Color.White)
                    }
                }
                Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                    when (selectedGenerationTab) {
                        GenerationTab.LIGHT_PALETTE -> Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
                            ) {
                                PaletteColors(
                                    palette = lightPalette,
                                    selectedPaletteColor = selectedLightPaletteColor,
                                    selectColor = selectLightPaletteColor
                                )
                            }
                            RectangularColorPicker(
                                modifier = Modifier.size(128.dp),
                                color = Color(selectedLightPaletteColor.argb),
                                onColorChange = { color ->
                                    updateLightPaletteColor(selectedLightPaletteColor, color)
                                }
                            )
                        }

                        GenerationTab.DARK_PALETTE -> Row(
                            modifier = Modifier.fillMaxSize(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
                            ) {
                                PaletteColors(
                                    palette = darkPalette,
                                    selectedPaletteColor = selectedDarkPaletteColor,
                                    selectColor = selectDarkPaletteColor
                                )
                            }
                            RectangularColorPicker(
                                modifier = Modifier.fillMaxWidth(.5f).fillMaxHeight(),
                                color = Color(selectedLightPaletteColor.argb),
                                onColorChange = { color ->
                                    updateLightPaletteColor(selectedLightPaletteColor, color)
                                }
                            )
                        }
                    }
                }
                Row(
                    modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(
                        space = 4.dp, alignment = Alignment.CenterHorizontally
                    ), verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        formattedScheme,
                        modifier = Modifier.weight(1f).padding(8.dp).verticalScroll(formattedSchemeScrollState)
                    )
                    Column(
                        modifier = Modifier.fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        IconButton(onClick = {
                            copyFormattedScheme(AnnotatedString(formattedScheme))
                        }) {
                            Icon(Icons.Default.ContentCopy, null)
                        }
                    }
                }
            }
        }
    )

    /*BottomDrawer(modifier = Modifier.fillMaxSize(), drawerContent = {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            TabRow(
                selectedTabIndex = selectedGenerationTab.ordinal, modifier = Modifier.fillMaxWidth()
            ) {
                Tab(selected = selectedGenerationTab == GenerationTab.LIGHT_PALETTE,
                    enabled = selectedGenerationTab != GenerationTab.LIGHT_PALETTE,
                    onClick = {
                        selectGenerationTab(GenerationTab.LIGHT_PALETTE)
                    }) {
                    Icon(Icons.Default.LightMode, null)
                }
                Tab(selected = selectedGenerationTab == GenerationTab.DARK_PALETTE,
                    enabled = selectedGenerationTab != GenerationTab.DARK_PALETTE,
                    onClick = {
                        selectGenerationTab(GenerationTab.DARK_PALETTE)
                    }) {
                    Icon(Icons.Default.DarkMode, null)
                }
            }
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                when (selectedGenerationTab) {
                    GenerationTab.LIGHT_PALETTE -> Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
                        ) {
                            PaletteColors(
                                palette = lightPalette,
                                selectedPaletteColor = selectedLightPaletteColor,
                                selectColor = selectLightPaletteColor
                            )
                        }
                        RectangularColorPicker(
                            modifier = Modifier.fillMaxHeight(),
                            color = Color(selectedLightPaletteColor.argb),
                            onColorChange = { color ->
                                updateLightPaletteColor(selectedLightPaletteColor, color)
                            }
                        )
                    }

                    GenerationTab.DARK_PALETTE -> Row(
                        modifier = Modifier.fillMaxSize(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier.weight(1f), contentAlignment = Alignment.Center
                        ) {
                            PaletteColors(
                                palette = darkPalette,
                                selectedPaletteColor = selectedDarkPaletteColor,
                                selectColor = selectDarkPaletteColor
                            )
                        }
                        RectangularColorPicker(
                            modifier = Modifier.fillMaxHeight(),
                            color = Color(selectedDarkPaletteColor.argb),
                            onColorChange = { color ->
                                updateDarkPaletteColor(selectedDarkPaletteColor, color)
                            }
                        )
                    }
                }
            }
            Row(
                modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.spacedBy(
                    space = 4.dp, alignment = Alignment.CenterHorizontally
                ), verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    formattedScheme,
                    modifier = Modifier.weight(1f).padding(8.dp).verticalScroll(formattedSchemeScrollState)
                )
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    IconButton(onClick = {
                        copyFormattedScheme(AnnotatedString(formattedScheme))
                    }) {
                        Icon(Icons.Default.ContentCopy, null)
                    }
                }
            }
        }
    }, content = {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            MaterialTheme(
                colors = when (selectedGenerationTab) {
                    GenerationTab.LIGHT_PALETTE -> lightPalette.toLightColors()

                    GenerationTab.DARK_PALETTE -> darkPalette.toDarkColors()
                }
            ) {
                Preview()
            }
        }
    })*/
}