package com.jminnovatech.enjoybazar

import android.app.Application
import com.jminnovatech.enjoybazar.core.session.SessionManager
import com.jminnovatech.enjoybazar.data.remote.api.RetrofitClient

class EnjoyBazarApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val sessionManager = SessionManager(this)
        RetrofitClient.init(sessionManager)
    }
}
