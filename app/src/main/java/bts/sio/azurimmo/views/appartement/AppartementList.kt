package bts.sio.azurimmo.views.appartement

import bts.sio.azurimmo.viewmodel.appartement.AppartementViewModel
import bts.sio.azurimmo.viewmodel.batiment.BatimentViewModel
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AppartementList(
    batimentId: Int, // Ajoutez ce paramètre
    viewModel: AppartementViewModel = viewModel(),
    onAppartementClick: (Unit) -> Unit,
    onAddAppartementClick: () -> Unit // Callback pour ajouter un bâtiment
)  {

    val viewModelBat: BatimentViewModel = viewModel()
    val appartements = viewModel.appartements.value
    val batiment = viewModelBat.batiment.value
    val isLoading = viewModel.isLoading.value
    val errorMessage = viewModel.errorMessage.value

    LaunchedEffect(batimentId) {
        viewModel.getAppartementsByBatimentId(batimentId)
        viewModelBat.getBatiment(batimentId)
    }
    Box(modifier = Modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            errorMessage != null -> {
                Text(
                    text = errorMessage ?: "Erreur inconnue",
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.error
                )
            }
            else -> {
                FloatingActionButton(
                    onClick = {
                        println("Bouton + cliqué") // Vérification Logcat
                        onAddAppartementClick()
                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd) // Assure qu'il est bien visible
                        .padding(16.dp)
                        .background(MaterialTheme.colorScheme.secondary),
                    content = {
                        Icon(Icons.Default.Add, contentDescription = "Ajouter un appartement")
                    }
                )
                LazyColumn {
                    if (batiment!=null) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally // Centrer le contenu horizontalement
                            ) {
                                Text(
                                    text = "Informations sur le bâtiment",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    color = MaterialTheme.colorScheme.primary
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Text(
                                    text = "Adresse : ${batiment.adresse}",
                                    style = MaterialTheme.typography.bodyLarge,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                                Text(
                                    text = "Ville : ${batiment.ville}",
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = MaterialTheme.colorScheme.onSurface
                                )
                            }
                        }

                        if (appartements.isNotEmpty()) {
                            /* BLOC AVEC LISTE DES APPARTEMENTS *********************/
                            // Ajouter un titre pour la liste des appartements
                            item {
                                Text(
                                    text = "Liste des appartements",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 1.dp)
                                        .padding(16.dp),
                                    textAlign = TextAlign.Center, // Alignement à gauche
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                            // Liste des appartements
                            items(appartements) { appartement ->
                                AppartementCard(appartement = appartement)
                            }
                        }
                        else
                        {
                            // Il n'y a pas d'appartement pour ce batiment
                            item {
                                Text(
                                    text = "Pas d'appartement pour ce batiment",
                                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(vertical = 1.dp)
                                        .padding(16.dp),
                                    textAlign = TextAlign.Center, // Alignement à gauche
                                    color = MaterialTheme.colorScheme.primary
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
