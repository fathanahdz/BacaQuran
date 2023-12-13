package com.d121211002.bacaquran.data.repository

import com.d121211002.bacaquran.data.source.remote.BacaQuranApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

interface BacaQuranContainer{
    val bacaQuranRepository: BacaQuranRepository
}


class DefaultAppContainer: BacaQuranContainer {
    private val BASE_URL = "https://quran-api-id.vercel.app/"

    /**
     * Use the Retrofit builder to build a retrofit object using a kotlinx.serialization converter
     */
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .baseUrl(BASE_URL)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService : BacaQuranApiService by lazy {
        retrofit.create(BacaQuranApiService::class.java)
    }

    /**
     * A public Api object that exposes the lazy-initialized Retrofit service
     */
    override val bacaQuranRepository: BacaQuranRepository by lazy {
        NetworkBacaQuranRepository(retrofitService)
    }
}