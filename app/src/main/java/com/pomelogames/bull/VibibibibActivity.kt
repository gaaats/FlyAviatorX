package com.pomelogames.bull

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import android.provider.MediaStore
import android.webkit.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.appsflyer.AppsFlyerLib
import com.google.android.material.snackbar.Snackbar
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import com.pomelogames.bull.StaatatrtttClass.Companion.C1ftgtgttg
import com.pomelogames.bull.StaatatrtttClass.Companion.DEEPLfrfrrf55fg
import com.pomelogames.bull.StaatatrtttClass.Companion.MAIN_IDdrfrrf8
import com.pomelogames.bull.StaatatrtttClass.Companion.linkfrfrrf
import com.pomelogames.bull.databinding.ActivityVibibibibBinding
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class VibibibibActivity : AppCompatActivity() {
    private val frfrftgt = 1
    var gthy: String? = null
    var jifrgtgt: ValueCallback<Array<Uri>>? = null

    lateinit var jikiik: WebView
    lateinit var hhyyyhyhy: ActivityVibibibibBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hhyyyhyhy = ActivityVibibibibBinding.inflate(layoutInflater)
        setContentView(hhyyyhyhy.root)

        jikiik = hhyyyhyhy.vivivivi
        Snackbar.make(
            hhyyyhyhy.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val frfrffrrf = CookieManager.getInstance()
        frfrffrrf.setAcceptCookie(true)
        frfrffrrf.setAcceptThirdPartyCookies(jikiik, true)
        koka()
        val tgtgtgttgtgt: Activity = this
        jikiik.webViewClient = object : WebViewClient() {


            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(url)) {
                        return false
                    }
                    if (gktkgt(url)) {

                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.data = Uri.parse(url)
                        startActivity(intent)
                    } else {

                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                view.loadUrl(url)
            }


            override fun onPageFinished(view: WebView, url: String) {
                super.onPageFinished(view, url)
                lkpikliliklilpk(url)
            }

            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(tgtgtgttgtgt, description, Toast.LENGTH_SHORT).show()
            }


        }
        jikiik.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                jifrgtgt?.onReceiveValue(null)
                jifrgtgt = filePathCallback
                var frgttakePictureIntent: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (frgttakePictureIntent!!.resolveActivity(packageManager) != null) {

                    var photoFiledefrfr: File? = null
                    try {
                        photoFiledefrfr = gtjigtjgjit()
                        frgttakePictureIntent.putExtra("PhotoPath", gthy)
                    } catch (ex: IOException) {
                    }

                    if (photoFiledefrfr != null) {
                        gthy = "file:" + photoFiledefrfr.absolutePath
                        frgttakePictureIntent.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFiledefrfr)
                        )
                    } else {
                        frgttakePictureIntent = null
                    }
                }
                val fhrhfhrhrf = Intent(Intent.ACTION_GET_CONTENT)
                fhrhfhrhrf.addCategory(Intent.CATEGORY_OPENABLE)
                fhrhfhrhrf.type = "image/*"
                val fuhrhfrhufr: Array<Intent?> =
                    frgttakePictureIntent?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val lpllp = Intent(Intent.ACTION_CHOOSER)
                lpllp.putExtra(Intent.EXTRA_INTENT, fhrhfhrhrf)
                lpllp.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_pic_choose))
                lpllp.putExtra(Intent.EXTRA_INITIAL_INTENTS, fuhrhfrhufr)
                startActivityForResult(
                    lpllp, frfrftgt
                )
                return true
            }

            @Throws(IOException::class)
            private fun gtjigtjgjit(): File {
                var gitjjgttg = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!gitjjgttg.exists()) {
                    gitjjgttg.mkdirs()
                }

                gitjjgttg =
                    File(gitjjgttg.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return gitjjgttg
            }

        }

        jikiik.loadUrl(gtjtjgjj())
    }


    private fun popop(string: String) {
        OneSignal.setExternalUserId(
            string,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val frrrfrfrfr = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $frrrfrfrfr"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val deefrgtyhuj =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $deefrgtyhuj"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val oiioiooi = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $oiioiooi"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(error: OneSignal.ExternalIdError) {
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }

    override fun onBackPressed() {


        if (jikiik.canGoBack()) {
            if (gtigjtj) {
                jikiik.stopLoading()
                jikiik.loadUrl(huyhkyhyk)
            }
            this.gtigjtj = true
            jikiik.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                gtigjtj = false
            }, 2000)

        } else {
            super.onBackPressed()
        }
    }

    private fun koka() {
        val boka = jikiik.settings
        boka.javaScriptEnabled = true

        boka.useWideViewPort = true

        boka.loadWithOverviewMode = true
        boka.allowFileAccess = true
        boka.domStorageEnabled = true
        boka.userAgentString = boka.userAgentString.replace("; wv", "")

        boka.javaScriptCanOpenWindowsAutomatically = true
        boka.setSupportMultipleWindows(false)

        boka.displayZoomControls = false
        boka.builtInZoomControls = true
        boka.setSupportZoom(true)

        boka.pluginState = WebSettings.PluginState.ON
        boka.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        boka.setAppCacheEnabled(true)

        boka.allowContentAccess = true
    }

    private fun gtjtjgjj(): String {

        val gtkkgtk = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)

        val monkey = "com.pomelogames.bull"

        val donkey:String? = Hawk.get(C1ftgtgttg, "null")
        val koko: String? = Hawk.get(MAIN_IDdrfrrf8, "null")
        val kokok: String? = Hawk.get(DEEPLfrfrrf55fg, "null")

        val jgijtjtj = AppsFlyerLib.getInstance().getAppsFlyerUID(this)


        AppsFlyerLib.getInstance().setCollectAndroidID(true)



        val frfrfr = "deviceID="
        val adidfrrf = "ad_id="
        val sub4frfrfr = "sub_id_4="
        val goktk = "sub_id_5="
        val sub6frrf = "sub_id_6="
        val fokgttg = "sub_id_1="





        val gttjjgtt = "naming"
        val ftgt = "deeporg"


        val gktkt = Build.VERSION.RELEASE

        val linkAB = Hawk.get(linkfrfrrf, "null")

        var fjrfjrfrfrf = ""
        if (donkey != "null"){
            fjrfjrfrfrf = "$linkAB$fokgttg$donkey&$frfrfr$jgijtjtj&$adidfrrf$koko&$sub4frfrfr$monkey&$goktk$gktkt&$sub6frrf$gttjjgtt"
            popop(jgijtjtj.toString())
        } else {
            fjrfjrfrfrf = "$linkAB$fokgttg$kokok&$frfrfr$jgijtjtj&$adidfrrf$koko&$sub4frfrfr$monkey&$goktk$gktkt&$sub6frrf$ftgt"
            popop(jgijtjtj.toString())
        }

        return gtkkgtk.getString("SAVED_URL", fjrfjrfrfrf).toString()
    }


    private fun gktkgt(uri: String): Boolean {

        val hykhkyk = packageManager
        try {

            hykhkyk.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)


            return true
        } catch (e: PackageManager.NameNotFoundException) {

        }
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode != frfrftgt || jifrgtgt == null) {
            super.onActivityResult(requestCode, resultCode, data)
            return
        }
        var results: Array<Uri>? = null

        if (resultCode == AppCompatActivity.RESULT_OK) {
            if (data == null || data.data == null) {
                results = arrayOf(Uri.parse(gthy))
            } else {
                val gjtjjgtj = data.dataString
                if (gjtjjgtj != null) {
                    results = arrayOf(Uri.parse(gjtjjgtj))
                }
            }
        }
        jifrgtgt?.onReceiveValue(results)
        jifrgtgt = null
    }

    fun lkpikliliklilpk(lurlurlurlurlur: String?) {
        if (!lurlurlurlurlur!!.contains("t.me")) {

            if (huyhkyhyk == "") {
                huyhkyhyk = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    lurlurlurlurlur
                ).toString()

                val rfrrfrfr = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val yhyhyhhyhy = rfrrfrfr.edit()
                yhyhyhhyhy.putString("SAVED_URL", lurlurlurlurlur)
                yhyhyhhyhy.apply()
            }
        }
    }
    private var gtigjtj = false


    var huyhkyhyk = ""



}