package hu.nmth.afd.di

import org.koin.dsl.module

val appModule = module {
    includes(
        uiModule,
        dataModule
    )
}