package bts.sio.azurimmo.views.contrat

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bts.sio.azurimmo.model.Contrat

@Composable
fun ContratCard(contrat: Contrat) {
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
            Text(text = "Contrat #${contrat.id}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Début: ${contrat.dateDebut}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Fin: ${contrat.dateFin}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Loyer: ${contrat.montantLoyer}€", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Charges: ${contrat.montantCharges}€", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Locataire: ${contrat.locataire.nom} ${contrat.locataire.prenom}", style = MaterialTheme.typography.bodyMedium)
            Text(text = "Appartement: ${contrat.appartement.numero}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
