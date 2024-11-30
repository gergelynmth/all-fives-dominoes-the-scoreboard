package hu.nmth.afd

import android.app.Application
import hu.nmth.afd.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AdfApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@AdfApplication)
            modules(appModule)
        }
    }
}