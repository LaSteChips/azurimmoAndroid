package bts.sio.azurimmo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import bts.sio.azurimmo.views.appartement.AppartementList
import bts.sio.azurimmo.views.batiment.BatimentList
import bts.sio.azurimmo.views.contrat.ContratList
import bts.sio.azurimmo.views.garant.GarantList
import bts.sio.azurimmo.views.intervention.InterventionList
import bts.sio.azurimmo.views.locataire.LocataireList
import bts.sio.azurimmo.views.paiement.PaiementList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewBatimentList() {
        BatimentList(onBatimentClick = {})
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewAppartementList() {
        AppartementList(batimentId = 1)
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewContratList() {
        ContratList()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewLocataireList() {
        LocataireList()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewGarantList() {
        GarantList()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewPaiementList() {
        PaiementList()
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewInterventionList() {
        InterventionList()
    }
}