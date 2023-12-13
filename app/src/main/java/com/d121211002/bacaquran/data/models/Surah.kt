package com.d121211002.bacaquran.data.models

data class Surah(
    val audio: String,
    val ayahs: List<Ayah>,
    val bismillah: Bismillah,
    val description: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelation: String,
    val translation: String
)