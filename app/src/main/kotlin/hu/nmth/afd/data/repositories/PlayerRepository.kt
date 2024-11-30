package hu.nmth.afd.data.repositories

import hu.nmth.afd.data.dao.PlayerDao
import hu.nmth.afd.data.entities.PlayerEntity
import hu.nmth.afd.domain.mapper.toPlayer
import hu.nmth.afd.domain.model.Player
import hu.nmth.afd.domain.repositories.IPlayerRepository

class PlayerRepository(
    private val playerDao: PlayerDao
) : IPlayerRepository {

    override suspend fun getPlayers(): List<Player> {
        return playerDao.getPlayers().map { it.toPlayer() }
    }

    override suspend fun addPlayer(name: String) {
        playerDao.addPlayer(
            PlayerEntity(
                name = name,
            )
        )
    }
}