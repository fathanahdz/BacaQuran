package com.d121211002.bacaquran.data.repository

import com.d121211002.bacaquran.data.models.Surah
import com.d121211002.bacaquran.data.models.SurahsItem
import com.d121211002.bacaquran.data.source.remote.BacaQuranApiService

/** Fetches list of Surah from bacaQuranApi */

interface BacaQuranRepository{
    suspend fun getSurahs(): List<SurahsItem>
    suspend fun getSurah(numberSurah: Int): Surah
}
/**
 * Network Implementation of Repository that fetch Surahs list from bacaQuranApi.
 */
class NetworkBacaQuranRepository(
    private val bacaQuranApiService: BacaQuranApiService
) : BacaQuranRepository{
    /**Fetches list of Surahs from bacaQuranApi*/
    override suspend fun getSurahs(): List<SurahsItem> = bacaQuranApiService.getSurahs()
    override suspend fun getSurah(numberSurah:Int): Surah = bacaQuranApiService.getSurah(numberSurah = numberSurah)

}