package preview

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PreviewCard() {
    Card(
        modifier = Modifier.fillMaxWidth().padding(16.dp),
        backgroundColor = MaterialTheme.colors.surface,
        contentColor = MaterialTheme.colors.onSurface
    ) {
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
}