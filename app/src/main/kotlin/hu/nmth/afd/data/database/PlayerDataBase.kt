package hu.nmth.afd.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.nmth.afd.data.dao.PlayerDao
import hu.nmth.afd.data.entities.PlayerEntity

@Database(entities = [(PlayerEntity::class)], version = 1)
abstract class PlayerDataBase: RoomDatabase() {
    abstract fun getPlayerDao(): PlayerDao
}