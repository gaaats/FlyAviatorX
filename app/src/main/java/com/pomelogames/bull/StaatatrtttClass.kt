package com.pomelogames.bull

import android.app.Application
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk

class StaatatrtttClass: Application() {


    companion object {
        const val dedeedeeedgtgt = "08437eaf-30ff-4445-afa6-6a4ec5ae2dc3"
        var appsCheckfrfrrf55 = "appsChecker"
        var MAIN_IDdrfrrf8: String? = ""
        var DEEPLfrfrrf55fg: String? = "d11"
        var C1ftgtgttg: String? = "c11"
        var linkfrfrrf = "link"

    }

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(dedeedeeedgtgt)

        Hawk.init(this).build()


    }

}
