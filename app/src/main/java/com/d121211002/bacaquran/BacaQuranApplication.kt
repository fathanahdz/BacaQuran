package com.d121211002.bacaquran

import android.app.Application
import com.d121211002.bacaquran.data.BacaQuranContainer
import com.d121211002.bacaquran.data.DefaultAppContainer

class BacaQuranApplication : Application(){
    lateinit var container : BacaQuranContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}