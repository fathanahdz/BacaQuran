package com.d121211002.bacaquran.data.models.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Audio(
    @SerialName(value="ahmedajamy")
    val ahmedajamy: String?,
    @SerialName(value="alafasy")
    val alafasy: String?,
    @SerialName(value="husarymujawwad")
    val husarymujawwad: String?,
    @SerialName(value="minshawi")
    val minshawi: String?,
    @SerialName(value="muhammadayyoub")
    val muhammadayyoub: String?,
    @SerialName(value="muhammadjibreel")
    val muhammadjibreel: String?
)