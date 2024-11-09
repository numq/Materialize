package preview

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun PreviewErrorMessage() {
    Text(
        text = "Error message", style = MaterialTheme.typography.body2, color = MaterialTheme.colors.error
    )
}