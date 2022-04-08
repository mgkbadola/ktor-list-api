package me.mgkbadola.models
import kotlinx.serialization.Serializable

@Serializable
data class APIJsonResponse<T>(val result: T, val status: String, val message: String)
