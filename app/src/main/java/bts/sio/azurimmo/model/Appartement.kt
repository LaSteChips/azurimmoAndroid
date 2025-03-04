package bts.sio.azurimmo.model

data class Appartement(
    val id: Int,
    val numero: String,
    val surface: Float,
    val batiment: Batiment,
    val description: String
)
