package bts.sio.azurimmo.views.intervention

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bts.sio.azurimmo.model.Intervention

@Composable
fun InterventionCard(intervention: Intervention) {
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
            Text(text = "Date de l'intervention : ${intervention.dateIntervention}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Entreprise : ${intervention.entreprise}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Note : ${intervention.noteIntervention}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Appartement: ${intervention.appartement.numero}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Adresse: ${intervention.appartement.batiment.adresse}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
