package com.d121211002.bacaquran.ui.activities

import android.app.Application
import com.d121211002.bacaquran.data.repository.BacaQuranContainer
import com.d121211002.bacaquran.data.repository.DefaultAppContainer

class BacaQuranApplication : Application(){
    lateinit var container : BacaQuranContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}