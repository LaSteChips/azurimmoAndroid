package bts.sio.azurimmo.model

data class Appartement(
    val id: Int,
    val numero: String,
    val batiment: Batiment
)