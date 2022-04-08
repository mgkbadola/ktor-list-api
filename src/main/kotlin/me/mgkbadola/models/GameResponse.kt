package me.mgkbadola.models
import kotlinx.serialization.Serializable

@Serializable
data class ReleaseDateResponse(val id: Int, val date: Long? = null)
@Serializable
data class GameResponse(val id: Int, val category: Int = 13, val game_modes: List<Int> = mutableListOf(),
                        val genres: List<Int> = mutableListOf(), val themes: List<Int> = mutableListOf(),
                        val name: String, val platforms: List<Int> = mutableListOf(),
                        val release_dates: List<ReleaseDateResponse> = mutableListOf())