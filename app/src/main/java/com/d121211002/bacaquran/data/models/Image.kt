package com.d121211002.bacaquran.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Image(
    @SerialName(value="primary")
    val primary: String?,
    @SerialName(value="secondary")
    val secondary: String?
)