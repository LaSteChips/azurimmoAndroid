package bts.sio.azurimmo.views

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun AppHeader() {
    Box(
        modifier = WatchEvent.Modifier
            .fillMaxWidth()
            .background(Color.Blue) // Fond bleu
            .padding(vertical = 16.dp) // Espacement vertical pour un effet plus aéré
    ) {
        Text(
            text = "Azurimmo", // Nom de l'application
            style = MaterialTheme.typography.titleLarge.copy(
                color = Color.White, // Texte blanc sur fond bleu
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.align(LineHeightStyle.Alignment.Center) // Centrer le texte
        )
    }
}