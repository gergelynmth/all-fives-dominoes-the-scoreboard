package hu.nmth.afd.feature.newgame

import hu.nmth.afd.domain.model.Player

sealed class NewGameIntent {
    data object LoadPlayers: NewGameIntent()
    data class OnPlayerSelected(val player: Player): NewGameIntent()
    data class AddPlayer(val name: String): NewGameIntent()
}