package com.d121211002.bacaquran.data.source.remote

import com.d121211002.bacaquran.data.models.Surah
import com.d121211002.bacaquran.data.models.SurahsItem
import retrofit2.http.GET
import retrofit2.http.Path

interface BacaQuranApiService {
    @GET ("surahs")
    suspend fun getSurahs():List<SurahsItem>
    @GET("surahs/{numberSurah}")
    suspend fun getSurah(@Path("numberSurah") numberSurah: Int): Surah

}