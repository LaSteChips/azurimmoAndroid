package bts.sio.azurimmo.model

import java.util.Date

data class Intervention(
    val id: Long,
    val dateIntervention: String,
    val entreprise: String,
    val noteIntervention: String,
    val appartement: Appartement
)
