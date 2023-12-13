package com.d121211002.bacaquran.data.models.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Bismillah(
    @SerialName(value="arab")
    val arab: String?,
    @SerialName(value="audio")
    val audio: Audio?,
    @SerialName(value="translation")
    val translation: String?
)