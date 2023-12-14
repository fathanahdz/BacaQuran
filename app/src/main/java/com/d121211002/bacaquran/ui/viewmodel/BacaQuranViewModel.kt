package com.d121211002.bacaquran.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.d121211002.bacaquran.data.repository.BacaQuranRepository
import com.d121211002.bacaquran.BacaQuranUiState
import com.d121211002.bacaquran.DetailSurahState
import com.d121211002.bacaquran.TempState
import com.d121211002.bacaquran.BacaQuranApplication
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.io.IOException




class BacaQuranViewModel(private val bacaQuranRepository: BacaQuranRepository) : ViewModel() {

    private val _tempState = MutableStateFlow(
        TempState(
        numberSurah = 0,
        screenState = BacaQuranUiState.Loading,
        detailScreenState = DetailSurahState.Loading)
    )
    val tempState : StateFlow<TempState> = _tempState.asStateFlow()
    init {
        getSurahs()
    }



    fun getSurahs() {
        viewModelScope.launch {
            _tempState.update { currentState -> currentState.copy(screenState = BacaQuranUiState.Loading) }
            try {
                var result = bacaQuranRepository.getSurahs()
                _tempState.update { currentState -> currentState.copy(screenState = BacaQuranUiState.Success(result))}

            } catch (e: IOException) {
                BacaQuranUiState.Error
            }
        }
    }

    fun getSurah(numberSurah: Int) = viewModelScope.launch {
        _tempState.update { currentState -> currentState.copy(detailScreenState =  DetailSurahState.Loading) }
        _tempState.update { currentState -> currentState.copy(numberSurah=numberSurah) }
        println("Detail Check")
        try {
            var result = bacaQuranRepository.getSurah(numberSurah)
            _tempState.update { currentState -> currentState.copy(detailScreenState = DetailSurahState.Success(result)) }
        }catch (e: IOException){
            _tempState.update { currentState -> currentState.copy(detailScreenState = DetailSurahState.Error)}
            DetailSurahState.Error
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