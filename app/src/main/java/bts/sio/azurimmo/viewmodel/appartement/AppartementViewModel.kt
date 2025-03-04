package bts.sio.azurimmo.viewmodel.appartement

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo.model.Appartement
import kotlinx.coroutines.launch

class AppartementViewModel : ViewModel() {

    // Liste mutable des bâtiments
    private val _appartements = mutableStateOf<List<Appartement>>(emptyList())
    val appartements: State<List<Appartement>> = _appartements

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    init {
        // Simuler un chargement de données initiales
        getAppartements()
    }

    private fun getAppartements() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getAppartements()
                _appartements.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
                println("pas de chargement")
            }
        }
    }

    fun getAppartementsByBatimentId(batimentId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getAppartementsByBatimentId(batimentId)

                println("Appartements reçus: $response") // Debugging

                _appartements.value = response.filter { it.batiment.id == batimentId }

                if (_appartements.value.isEmpty()) {
                    println("Aucun appartement trouvé pour le bâtiment $batimentId")
                }
            } catch (e: Exception) {
                println("Erreur lors du chargement des appartements : ${e.message}")
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addAppartement(appartement: Appartement) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.addAppartement(appartement)
                if (response.isSuccessful) {
                    // Recharger les bâtiments après ajout
                    getAppartements()
                } else {
                    _errorMessage.value = "Erreur lors de l'ajout du bâtiment : ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}