package com.d121211002.bacaquran.data.models.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Number(
    @SerialName(value="inQuran")
    val inQuran: Int?,
    @SerialName(value="inSurah")
    val inSurah: Int?
)