package hu.nmth.afd.feature.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.nmth.afd.domain.model.DEFAULT_PLAYER
import hu.nmth.afd.domain.model.Player
import hu.nmth.afd.feature.game.mapper.toPlayerScore
import hu.nmth.afd.feature.game.model.PlayerScore
import hu.nmth.afd.feature.game.model.addScore
import hu.nmth.afd.feature.game.model.removeLastScore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel(
    player1: Player,
    player2: Player,
    player3: Player,
    player4: Player,
) : ViewModel() {

    private val _state = MutableStateFlow(GameViewState())
    val state: StateFlow<GameViewState> = _state

    init {
        _state.value = _state.value.copy(
            players = listOfNotNull(
                player1.toPlayerScore(),
                player2.toPlayerScore(),
                player3.takeUnless { it == DEFAULT_PLAYER }?.toPlayerScore(),
                player4.takeUnless { it == DEFAULT_PLAYER }?.toPlayerScore(),
            ),
            currentPlayer = player1.toPlayerScore()
        )
    }

    fun handleIntent(intent: GameIntent) {
        viewModelScope.launch {
            when (intent) {
                is GameIntent.AddScore -> addScore(score = intent.score)
                GameIntent.DeleteScoreByOne -> deleteScoreByOne()
                is GameIntent.AddScoreToPlayer -> addScoreToPlayer()
                is GameIntent.PlayerSelected -> onPlayerSelected(player = intent.playerScore)
                GameIntent.Replay -> replay()
            }
        }
    }

    // Add score on display
    private fun addScore(score: String) {
        val currentScore = _state.value.currentScore
        _state.value = _state.value.copy(currentScore = currentScore + score)
    }

    // Delete one char from the score on display
    private fun deleteScoreByOne() {
        val currentScore = _state.value.currentScore
        _state.value = _state.value.copy(currentScore = currentScore.dropLast(1))
    }

    // When add button clicked, add score to the current player
    private fun addScoreToPlayer() {
        val state = _state.value
        val currentPlayer = state.currentPlayer ?: return
        val currentScore = state.currentScore.toIntOrNull() ?: return

        val updatedPlayers = state.players.map { player ->
            if (player.id == currentPlayer.id) {
                player.addScore(currentScore)
            } else {
                player
            }
        }

        _state.value = state.copy(
            players = updatedPlayers,
            currentScore = ""
        )

        addScoreToHistory(currentPlayer)

        // Check if the player won the game
        updatedPlayers.find { currentPlayer.id == it.id }?.let {
            checkWinner(it)
        }
    }

    private fun checkWinner(player: PlayerScore) {
        val lastScore = player.scores.lastOrNull() ?: return
        if (lastScore >= 100) {
            _state.value = _state.value.copy(winner = player)
        }
    }

    // Change current player
    private fun onPlayerSelected(player: PlayerScore) {
        _state.value = _state.value.copy(currentPlayer = player)
    }

    // Add score to history, when player got score
    private fun addScoreToHistory(player: PlayerScore) {
        _state.value = _state.value.copy(
            history = _state.value.history + player.id
        )
    }

    // Handle replay event
    // Remove last element of the history, remove the last player's last score
    private fun replay() {
        val state = _state.value

        if (state.history.isEmpty()) return

        val lastPlayerId = state.history.last()
        val updatedHistory = state.history.dropLast(1)

        val updatedPlayers = state.players.map { player ->
            if (player.id == lastPlayerId) {
                player.removeLastScore()
            } else {
                player
            }
        }

        _state.value = state.copy(
            players = updatedPlayers,
            history = updatedHistory
        )
    }
}