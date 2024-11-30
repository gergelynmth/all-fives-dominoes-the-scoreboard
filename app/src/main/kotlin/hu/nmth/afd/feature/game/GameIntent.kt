package hu.nmth.afd.feature.game

import hu.nmth.afd.feature.game.model.PlayerScore
import hu.nmth.afd.feature.newgame.NewGameIntent

sealed class GameIntent {
    data class AddScore(val score: String) : GameIntent()
    data object DeleteScoreByOne: GameIntent()
    data object AddScoreToPlayer : GameIntent()
    data class PlayerSelected(val playerScore: PlayerScore) : GameIntent()
    data object Replay : GameIntent()
}