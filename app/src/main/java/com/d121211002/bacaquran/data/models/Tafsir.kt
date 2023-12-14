package com.d121211002.bacaquran.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tafsir(
    @SerialName(value="jalalayn")
    val jalalayn: String?,
    @SerialName(value="kemenag")
    val kemenag: Kemenag?,
    @SerialName(value="quraish")
    val quraish: String?
)