package hu.nmth.afd.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hu.nmth.afd.data.entities.PlayerEntity

@Dao
interface PlayerDao {

    @Query("SELECT * FROM players")
    suspend fun getPlayers(): List<PlayerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlayer(playerEntity: PlayerEntity)
}