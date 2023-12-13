package com.d121211002.bacaquran.data.models.detail

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName(value="hizbQuarter")
    val hizbQuarter: Int?,
    @SerialName(value="juz")
    val juz: Int?,
    @SerialName(value="manzil")
    val manzil: Int?,
    @SerialName(value="page")
    val page: Int?,
    @SerialName(value="ruku")
    val ruku: Int?,
    @SerialName(value="sajda")
    val sajda: Sajda?
)