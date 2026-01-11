package com.jminnovatech.enjoybazar

import android.app.Application
import com.jminnovatech.enjoybazar.core.session.SessionManager
import com.jminnovatech.enjoybazar.data.remote.api.RetrofitClient

class EnjoyBazarApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // ✅ INIT ONCE — BEFORE ANY API / VIEWMODEL
        RetrofitClient.init(SessionManager(this))
    }
}
