package hu.nmth.afd.di

import android.app.Application
import androidx.room.Room
import hu.nmth.afd.data.dao.PlayerDao
import hu.nmth.afd.data.database.PlayerDataBase
import hu.nmth.afd.data.repositories.PlayerRepository
import hu.nmth.afd.domain.repositories.IPlayerRepository
import org.koin.dsl.module

val dataModule = module {
    // Player
    single { providePlayerDataBase(get()) }
    single { providePlayerDao(get()) }
    single<IPlayerRepository> { PlayerRepository(get()) }
}

fun providePlayerDataBase(application: Application): PlayerDataBase =
    Room.databaseBuilder(
        application,
        PlayerDataBase::class.java,
        "player_database"
    ).fallbackToDestructiveMigration().build()

fun providePlayerDao(playerDataBase: PlayerDataBase): PlayerDao = playerDataBase.getPlayerDao()
