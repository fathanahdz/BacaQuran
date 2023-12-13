package com.d121211002.bacaquran.data.models.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Ayah(
    @SerialName(value="arab")
    val arab: String?,
    @SerialName(value="audio")
    val audio: Audio?,
    @SerialName(value="image")
    val image: Image,
    @SerialName(value="meta")
    val meta: Meta?,
    @SerialName(value="number")
    val number: Number?,
    @SerialName(value="tafsir")
    val tafsir: String?,
    @SerialName(value="translation")
    val translation: String?
)