package preview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun Preview() {
    val coroutineScope = rememberCoroutineScope()

    val scaffoldState = rememberScaffoldState()

    Scaffold(modifier = Modifier.fillMaxSize(), scaffoldState = scaffoldState, topBar = {
        TopAppBar(title = { Text("Color Scheme Demo") }, navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch { scaffoldState.drawerState.open() }
            }) {
                Icon(Icons.Default.Menu, contentDescription = "Menu")
            }
        })
    }, bottomBar = {
        BottomAppBar {
            BottomNavigationItem(selected = true, onClick = {}, icon = {
                Icon(Icons.Default.Home, "Home")
            })
            BottomNavigationItem(selected = false, onClick = {}, icon = {
                Icon(Icons.Default.Favorite, "Favorite")
            })
        }
    }, floatingActionButton = {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Default.Favorite, contentDescription = "Favorite")
        }
    }, drawerContent = {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text(
                text = "Drawer Menu",
                style = MaterialTheme.typography.h6,
            )
            Spacer(modifier = Modifier.height(16.dp))

            PreviewDrawerItem("Settings", Icons.Default.Settings) {}
            PreviewDrawerItem("Favorite", Icons.Default.Favorite) {}
            PreviewDrawerItem("Log out", null) {}
        }
    }) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Card(modifier = Modifier.padding(16.dp)) {
                Column(
                    modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text("Card Example", style = MaterialTheme.typography.h6)
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {}) {
                        Text("Action Button")
                    }
                }
            }

            Button(
                onClick = {}, modifier = Modifier.padding(16.dp)
            ) {
                Text("Primary Button")
            }

            Spacer(modifier = Modifier.height(16.dp))
            BasicTextField(
                value = "Editable Text",
                onValueChange = {},
                textStyle = TextStyle(fontSize = 18.sp),
                modifier = Modifier.padding(16.dp).padding(8.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Error message", style = MaterialTheme.typography.body2)
        }
    }
}