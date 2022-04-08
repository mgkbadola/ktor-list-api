package me.mgkbadola.models
import kotlinx.serialization.Serializable

@Serializable
data class TokenResponse(val access_token: String, val expires_in: Long, val token_type: String)