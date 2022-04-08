package me.mgkbadola.models
import me.mgkbadola.utils.CATEGORIES
import kotlinx.serialization.Serializable

@Serializable
data class Game(val id: Int, val name: String, val category: String = CATEGORIES[13],
                val game_modes: List<String> = mutableListOf(), val genres: List<String> = mutableListOf(),
                val themes: List<String> = mutableListOf(), val platforms: List<String> = mutableListOf(),
                val release_dates: List<String> = mutableListOf(), val client: String = "-")
