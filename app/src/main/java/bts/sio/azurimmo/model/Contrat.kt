package bts.sio.azurimmo.model

data class Contrat(
    val id: Int,
    val dateDebut: String,
    val dateFin: String,
    val montantLoyer: Float,
    val montantCharges: Float,
    val appartement: Appartement, // Relation avec Appartement
    val locataire: Locataire // Relation avec Locataire
)
