package com.d121211002.bacaquran

import com.d121211002.bacaquran.data.models.Surah
import com.d121211002.bacaquran.data.models.SurahsItem

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

data class TempState(
    val numberSurah: Int = 0,
    val screenState: BacaQuranUiState,
    val detailScreenState: DetailSurahState,
){

}

