package hu.nmth.afd.feature.newgame

import hu.nmth.afd.domain.model.Player

data class NewGameViewState(
    val loading: Boolean = false,
    val players: List<Player> = emptyList(),
    val selectedPlayers: List<Player> = emptyList(),
    var error: NewGameError? = null,
    var isSetupReady: Boolean = false,
)

enum class NewGameError {
    NOT_ENOUGH_PLAYER,
    TOO_MANY_PLAYER
}
