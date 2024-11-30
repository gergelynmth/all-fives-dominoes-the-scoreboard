package hu.nmth.afd.feature.newgame

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hu.nmth.afd.domain.model.Player
import hu.nmth.afd.domain.repositories.IPlayerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewGameViewModel(
    private val playerRepository: IPlayerRepository
) : ViewModel() {

    private val _state = MutableStateFlow(NewGameViewState())
    val state: StateFlow<NewGameViewState> = _state

    fun handleIntent(intent: NewGameIntent) {
        viewModelScope.launch {
            when (intent) {
                NewGameIntent.LoadPlayers -> fetchPlayers()
                is NewGameIntent.OnPlayerSelected -> onPlayerSelected(intent.player)
                is NewGameIntent.AddPlayer -> addPlayer(intent.name)
            }
        }
    }

    private suspend fun fetchPlayers() {
        _state.value = _state.value.copy(loading = true)
        try {
            val players = playerRepository.getPlayers()
            _state.value = NewGameViewState(loading = false, players = players)
        } catch (e: Exception) {
            _state.value =
                NewGameViewState(loading = false)
        }
    }

    private fun onPlayerSelected(selectedPlayer: Player) {
        _state.value = _state.value.copy(
            selectedPlayers = _state.value.selectedPlayers.toMutableList().apply {
                if (contains(selectedPlayer)) {
                    remove(selectedPlayer)
                } else {
                    add(selectedPlayer)
                }
            }
        )

        checkGameReady()
    }

    private fun addPlayer(name: String) {
        viewModelScope.launch {
            playerRepository.addPlayer(name)
            fetchPlayers()
        }
    }

    private fun checkGameReady() {
        val playerCount = _state.value.selectedPlayers.size

        _state.value.isSetupReady = when {
            playerCount < 2 -> false
            playerCount > 4 -> false
            else -> true
        }
    }
}