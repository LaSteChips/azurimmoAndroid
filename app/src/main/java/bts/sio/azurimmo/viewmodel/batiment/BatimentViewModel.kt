import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import bts.sio.azurimmo.model.Batiment
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BatimentViewModel : ViewModel() {
    private val _batiments = mutableStateOf<List<Batiment>>(emptyList())
    val batiments: State<List<Batiment>> = _batiments

    private val _batiment = mutableStateOf<Batiment?>(null)
    val batiment: State<Batiment?> = _batiment

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    init {
        getBatiments()
    }

    private fun getBatiments() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getBatiments()
                _batiments.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    // 🔹 Nouvelle méthode pour récupérer un bâtiment par ID
    fun getBatimentById(batimentId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getBatimentById(batimentId)
                if (response.isSuccessful) {
                    _batiment.value = response.body()
                } else {
                    _errorMessage.value = "Erreur serveur : ${response.code()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
