package com.d121211002.bacaquran.data.models.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Surah(
    @SerialName(value="audio")
    val audio: String?,
    @SerialName(value="ayahs")
    val ayahs: List<Ayah>,
    @SerialName(value="bismillah")
    val bismillah: Bismillah,
    @SerialName(value="description")
    val description: String?,
    @SerialName(value="name")
    val name: String?,
    @SerialName(value="number")
    val number: Int?,
    @SerialName(value="numberOfAyahs")
    val numberOfAyahs: Int?,
    @SerialName(value="revelation")
    val revelation: String?,
    @SerialName(value="translation")
    val translation: String?
)