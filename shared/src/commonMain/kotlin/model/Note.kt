package model

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: String,
    val name: String,
    val description: String,
    val createdDate: String)

