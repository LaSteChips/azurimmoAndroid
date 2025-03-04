package bts.sio.azurimmo.viewmodel.batiment

import RetrofitInstance
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import bts.sio.azurimmo.model.Batiment
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class BatimentViewModel : ViewModel() {

    // Liste mutable des bâtiments
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
        println("batiment appeler")
    }

    fun getBatiments() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getBatiments()
                _batiments.value = response
                println("Réponse API : ${response.joinToString { it.id.toString() }}")
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun getBatiment(batimentId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getBatimentById(batimentId)
                _batiment.value = response
                println("Bâtiment chargé : $response")
            } catch (e: Exception) {
                println("Erreur lors du chargement du bâtiment : ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun addBatiment(batiment: Batiment) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.addBatiment(batiment)
                if (response.isSuccessful) {
                    // Recharger les bâtiments après ajout
                    getBatiments()
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