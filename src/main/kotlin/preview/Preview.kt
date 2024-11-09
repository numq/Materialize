package preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun Preview() {
    val coroutineScope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()

    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState, topBar = {
        TopAppBar(title = { Text("Material Theme Preview") },
            backgroundColor = MaterialTheme.colors.primary,
            navigationIcon = {
                IconButton(onClick = {
                    coroutineScope.launch { scaffoldState.drawerState.open() }
                }) {
                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                }
            })
    }, bottomBar = {
        BottomAppBar(backgroundColor = MaterialTheme.colors.primaryVariant) {
            BottomNavigationItem(selected = true, onClick = {}, icon = {
                Icon(Icons.Default.Home, contentDescription = "Home")
            })
            BottomNavigationItem(selected = false, onClick = {}, icon = {
                Icon(Icons.Default.Favorite, contentDescription = "Favorite")
            })
        }
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = {}, backgroundColor = MaterialTheme.colors.secondary
        ) {
            Icon(Icons.Default.Favorite, contentDescription = "Favorite")
        }
    }, drawerContent = {
        PreviewDrawerContent()
    }) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).background(MaterialTheme.colors.background)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            PreviewCard()
            PreviewButton()
            PreviewTextField()
            PreviewErrorMessage()
        }
    }
}