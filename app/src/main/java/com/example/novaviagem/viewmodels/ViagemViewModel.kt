/*package com.example.novaviagem.viewmodels

import androidx.lifecycle.ViewModel
import com.example.novaviagem.model.Viagem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update




Estava dando erro por causa do "copy" e eu não consegui achar uma maneira de resolver



class ViagemViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(Viagem())
    val uiState: StateFlow<Viagem> = _uiState.asStateFlow()

    fun updateDestino(newDestino: String) {
        _uiState.update {
            it.copy(destino = newDestino)
        }
    }

    fun updateTipo(newTipo: String) {
        _uiState.update {
            it.copy(tipo = newTipo)
        }
    }

    fun updateDataIni(newDataIni: Long) {
        _uiState.update {
            it.copy(dataIni = newDataIni)
        }
    }

    fun updateDataFim(newDataFim: Long) {
        _uiState.update {
            it.copy(dataFim = newDataFim)
        }
    }

    fun updateOrcamento(newOrcamento: Float) {
        _uiState.update {
            it.copy(orcamento = newOrcamento)
        }
    }
}*/