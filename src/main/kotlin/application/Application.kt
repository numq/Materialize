package application

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.singleWindowApplication
import decoration.DecorationBox
import di.appModule
import navigation.Navigation
import org.koin.core.context.startKoin
import kotlin.system.exitProcess

private const val appName = "Compose Color Scheme Generator"

fun main() {
    startKoin {
        modules(appModule)
    }

    singleWindowApplication(
        state = WindowState(size = DpSize(width = 768.dp, height = 512.dp)),
        undecorated = true
    ) {
        MaterialTheme {
            Column(
                modifier = Modifier.fillMaxSize().background(Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                DecorationBox(
                    window = window,
                    close = { exitProcess(0) },
                    content = {
                        Text(appName, color = Color.Black, modifier = Modifier.padding(4.dp))
                    }
                )
                Navigation()
            }
        }
    }
}