package preview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PreviewTextField() {
    BasicTextField(
        value = "Editable Text",
        onValueChange = {},
        textStyle = TextStyle(color = MaterialTheme.colors.onBackground, fontSize = 18.sp),
        modifier = Modifier.fillMaxWidth().background(MaterialTheme.colors.surface, shape = MaterialTheme.shapes.small)
            .padding(16.dp)
    )
}