package com.d121211002.bacaquran.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Kemenag(
    @SerialName(value="long")
    val long: String?,
    @SerialName(value="short")
    val short: String?
)