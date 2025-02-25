package com.anvarpasha.avtogarage.data.network.persistence

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.anvarpasha.avtogarage.di.appModule
import org.koin.android.ext.android.startKoin

val prefs: PreferenceHelper by lazy {
    GarageApp.prefs!!
}

class GarageApp : MultiDexApplication() {

    val TAG: String = "GarageApp"

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        lateinit var user: String
        var prefs: PreferenceHelper? = null
    }

    override fun onCreate() {
        prefs = PreferenceHelper(applicationContext)
        super.onCreate()


        startKoin(this, listOf(appModule))


    }
}
