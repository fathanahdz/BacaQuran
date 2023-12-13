package com.d121211002.bacaquran.ui

import com.d121211002.bacaquran.data.models.Surah

sealed interface BacaQuranUiState {
    data class Success(val surahs: List<Surah>) : BacaQuranUiState
    object Error : BacaQuranUiState
    object Loading : BacaQuranUiState
}