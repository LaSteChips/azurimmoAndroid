package bts.sio.azurimmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import bts.sio.azurimmo.views.appartement.AppartementList
import bts.sio.azurimmo.views.batiment.BatimentList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Appel de la fonction principale pour structurer l'affichage
            AppartementList()
        }
    }

    // Fonction pour prévisualiser BatimentList uniquement
    @Preview(showBackground = true)
    @Composable
    fun PreviewBatimentList() {
        BatimentList()
    }

    // Fonction pour prévisualiser AppartementList uniquement
    @Preview(showBackground = true)
    @Composable
    fun PreviewAppartementList() {
        AppartementList()
    }
}

// Fonction principale pour afficher les listes
//@Composable
//fun MainScreen() {
//    Column {
//        // Affiche la liste des bâtiments
//        BatimentList()
//        // Affiche la liste des appartements
//        AppartementList()
//    }
//}
