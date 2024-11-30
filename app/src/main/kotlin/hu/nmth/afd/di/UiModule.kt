package hu.nmth.afd.di

import hu.nmth.afd.feature.game.GameViewModel
import hu.nmth.afd.feature.newgame.NewGameViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { NewGameViewModel(get()) }
    viewModel { parameters ->
        GameViewModel(
            player1 = parameters.get(),
            player2 = parameters.get(),
            player3 = parameters.get(),
            player4 = parameters.get(),
        )
    }
}