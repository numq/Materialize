package preview

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PreviewDrawerContent() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text("Drawer Menu", style = MaterialTheme.typography.h6, color = MaterialTheme.colors.onSurface)
        Spacer(modifier = Modifier.height(16.dp))

        PreviewDrawerItem("Settings", Icons.Default.Settings) {}
        PreviewDrawerItem("Favorite", Icons.Default.Favorite) {}
        PreviewDrawerItem("Log out", Icons.Default.ExitToApp) {}
    }
}