package hu.nmth.afd.feature.game

import hu.nmth.afd.domain.model.Player
import kotlinx.serialization.Serializable

@Serializable
data class GameScreenDestination(
    // Do it better
    val player1: Player,
    val player2: Player,
    val player3: Player,
    val player4: Player,
)

