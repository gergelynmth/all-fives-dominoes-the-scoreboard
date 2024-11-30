package hu.nmth.afd.domain.repositories

import hu.nmth.afd.domain.model.Player

interface IPlayerRepository {
    suspend fun getPlayers() : List<Player>
    suspend fun addPlayer(name: String)
}