package application

import androidx.compose.material.MaterialTheme
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import di.appModule
import navigation.Navigation
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(appModule)
    }

    singleWindowApplication(
        title = "Compose Color Scheme Generator",
        state = WindowState(size = DpSize(width = 512.dp, height = 512.dp))
    ) {
        MaterialTheme {
            Navigation()
        }
    }
}