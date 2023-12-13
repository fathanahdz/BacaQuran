package com.d121211002.bacaquran.ui.activities

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211002.bacaquran.data.repository.BacaQuranRepository
import com.d121211002.bacaquran.ui.BacaQuranUiState
import kotlinx.coroutines.launch
import java.io.IOException




class BacaQuranViewModel(private val bacaQuranRepository: BacaQuranRepository) : ViewModel() {
    var bacaQuranUiState: BacaQuranUiState by mutableStateOf(BacaQuranUiState.Loading)
        private set


    init {
        getSurahs()
    }



    fun getSurahs() {
        viewModelScope.launch {
            bacaQuranUiState = BacaQuranUiState.Loading
            try {
                var result = bacaQuranRepository.getSurahs()
                bacaQuranUiState = BacaQuranUiState.Success(result.results.orEmpty())
            } catch (e: IOException) {
                BacaQuranUiState.Error
            }
        }
    }

    fun getSurah() = viewModelScope.launch {
        bacaQuranUiState = BacaQuranUiState.Loading
        try {
            var result = bacaQuranRepository.getSurah()
            BacaQuranUiState.Success(result)
        }catch (e: IOException){
            BacaQuranUiState
        }
    }



    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as BacaQuranApplication)
                val bacaQuranRepository = application.container.bacaQuranRepository
                BacaQuranViewModel(bacaQuranRepository = bacaQuranRepository)
            }
        }
    }
}