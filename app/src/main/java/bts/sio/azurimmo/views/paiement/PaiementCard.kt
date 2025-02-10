package bts.sio.azurimmo.views.paiement

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import bts.sio.azurimmo.model.Paiement

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PaiementCard(paiement: Paiement) {
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
            // Afficher la date formatée
            val formattedDate = paiement.date.toString() // La date est maintenant un LocalDate
            Text(text = "Paiement effectué le $formattedDate", style = MaterialTheme.typography.bodyLarge)

            // Afficher le montant du paiement
            Text(text = "Montant: ${paiement.montant}€", style = MaterialTheme.typography.bodyMedium)
        }
    }
}