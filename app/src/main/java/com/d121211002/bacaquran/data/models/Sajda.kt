package com.d121211002.bacaquran.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Sajda(
    @SerialName(value="obligatory")
    val obligatory: Boolean?,
    @SerialName(value="recommended")
    val recommended: Boolean?
)