package lbc.gallery.app

import android.app.Application

/**
 * Created by Safa NAOUI on 20/12/2020.
 */
class GalleryApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: GalleryApplication
    }
}