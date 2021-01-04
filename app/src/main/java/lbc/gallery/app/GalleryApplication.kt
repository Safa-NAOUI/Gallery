package lbc.gallery.app

import android.app.Application
import kotlinx.coroutines.ObsoleteCoroutinesApi
import lbc.gallery.app.di.networkModules
import lbc.gallery.app.di.repositoryModules
import lbc.gallery.app.di.useCaseModules
import lbc.gallery.app.di.viewModels
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by Safa NAOUI on 20/12/2020.
 */
class GalleryApplication : Application() {

    @ObsoleteCoroutinesApi
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GalleryApplication)
            modules(
                viewModels +
                        repositoryModules +
                        useCaseModules
                        +networkModules
            )
        }
        instance = this
    }

    companion object {
        lateinit var instance: GalleryApplication
            private set
    }
}