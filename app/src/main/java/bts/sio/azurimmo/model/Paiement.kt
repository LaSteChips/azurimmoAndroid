package bts.sio.azurimmo.model

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Paiement(
    val id: Int,
    val montant: Double,
    val datePaiement: String // Date sous forme de chaîne
) {
    // Fonction pour convertir la chaîne datePaiement en LocalDate
    val date: LocalDate
        @RequiresApi(Build.VERSION_CODES.O)
        get() = LocalDate.parse(datePaiement, DateTimeFormatter.ISO_DATE)
}