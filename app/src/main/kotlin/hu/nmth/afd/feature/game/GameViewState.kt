package hu.nmth.afd.feature.game

import hu.nmth.afd.feature.game.model.PlayerScore

data class GameViewState(
    val loading: Boolean = false,
    val players: List<PlayerScore> = emptyList(),
    val currentPlayer: PlayerScore? = null,
    val currentScore: String = "",
    val history: List<Long> = emptyList(),
    val winner: PlayerScore? = null,
)