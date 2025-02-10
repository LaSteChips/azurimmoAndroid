package bts.sio.azurimmo.views.locataire

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bts.sio.azurimmo.model.Locataire

@Composable
fun LocataireCard(locataire: Locataire) {  // Ici, on attend un objet de type Locataire
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Prénom: ${locataire.prenom}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Nom: ${locataire.nom}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
