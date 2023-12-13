package com.d121211002.bacaquran.ui

import com.d121211002.bacaquran.data.models.detail.Surah
import com.d121211002.bacaquran.data.models.detail.SurahsItem

sealed interface BacaQuranUiState {
    data class Success(val surahs: List<SurahsItem>) : BacaQuranUiState
    object Error : BacaQuranUiState
    object Loading : BacaQuranUiState
}

sealed interface DetailSurahState{
    data class Success(val surah: Surah): DetailSurahState
    object Error : DetailSurahState
    object Loading : DetailSurahState

}

data class BacaQuranUiState(
    val listScreenState: BacaQuranUiState = BacaQuranUiState.Start,
    val detailSurahState: DetailSurahState = DetailSurahState.Loading,

)