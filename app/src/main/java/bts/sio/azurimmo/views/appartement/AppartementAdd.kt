package bts.sio.azurimmo.views.appartement

import bts.sio.azurimmo.viewmodel.appartement.AppartementViewModel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import bts.sio.azurimmo.model.Appartement
import bts.sio.azurimmo.model.Batiment

@Composable
fun AppartementAdd(onAddAppartement: (Appartement) -> Unit, batimentId: Int) {
    val viewModel: AppartementViewModel = viewModel()
    var description by remember { mutableStateOf("") }
    var numero by remember { mutableStateOf("") }
    var surface by remember { mutableFloatStateOf(0f) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("description") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = numero,
            onValueChange = { numero = it },
            label = { Text("numero") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = if (surface == 0f) "" else surface.toString(),
            onValueChange = { input ->
                surface = input.toFloatOrNull() ?: 0f
            },
            label = { Text("surface (en m²)") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val batiment = Batiment(id = batimentId, adresse = "zouzou", ville = "labas") // seul l’id nous interesse ici
                val appartement = Appartement(
                    id = 0,
                    numero = numero,
                    description = description,
                    surface = surface,
                    batiment = batiment
                )
                viewModel.addAppartement(appartement)
                onAddAppartement(appartement)
            },
            modifier = Modifier.align(Alignment.End),
            enabled = description.isNotBlank() && numero.isNotBlank()
        ) {
            Text("Ajouter le batiment ")
        }
    }
}