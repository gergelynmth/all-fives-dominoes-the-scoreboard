package hu.nmth.afd.feature.players

import androidx.lifecycle.ViewModel
import hu.nmth.afd.domain.repositories.IPlayerRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PlayersViewModel(
    private val playerRepository: IPlayerRepository
) : ViewModel() {

    private val _state = MutableStateFlow(PlayersViewState())
    val state: StateFlow<PlayersViewState> = _state
}