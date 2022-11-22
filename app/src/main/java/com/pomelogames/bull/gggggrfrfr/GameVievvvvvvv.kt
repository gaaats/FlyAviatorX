package com.pomelogames.bull.gggggrfrfr

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.pomelogames.bull.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameVievvvvvvv(
    var frfrrfrf: Context,
    var gameTask1111: GameTaskkkkkk,
    val defrrmyCarfrrg: Int,
    val enemyLogoListdfefrrf: List<Int>
) : View(frfrrfrf) {


    private var ftgtgt = 8
    private var frfrrrr5def = 0
    private var ppppppppppp1: Paint? = null
    private var myPaintBonusdrfrrrfrgtt: Paint? = null
    private var myPaintLifeTextfrfrr5: Paint? = null
    private var frgtgttimeeeeeeeeeeeetiememe = 0
    private var gtttg = Paint()
    private var edfrrrf5rr5 = 0


    private var fgtgtgtgt = 3


    var frggt = System.currentTimeMillis()

    private var fgtgtgt = 0

    private var totototo = ArrayList<HashMap<String, Any>>()
    private var gtgtjt = ArrayList<HashMap<String, Any>>()

    private var gjtgtjtg = 0
    private var dfrfrrrr7 = 0
    private var tltltltlt = ""

    var enenenenen = enemyLogoListdfefrrf.random()


    init {
        ppppppppppp1 = Paint()
        gtttg.color = Color.GREEN
        myPaintBonusdrfrrrfrgtt = Paint()
        myPaintLifeTextfrfrr5 = Paint()
        myPaintLifeTextfrfrr5!!.textSize = 100f
        myPaintLifeTextfrfrr5!!.alpha = 190
        myPaintLifeTextfrfrr5!!.color = Color.WHITE
    }

    override fun onDraw(canvas: Canvas?) {

        canvas!!.drawText(
            tltltltlt,
            gjtgtjtg / 2f - 220f,
            dfrfrrrr7 / 2f,
            myPaintLifeTextfrfrr5!!
        )


        super.onDraw(canvas)

        gjtgtjtg = this@GameVievvvvvvv.measuredWidth
        dfrfrrrr7 = this@GameVievvvvvvv.measuredHeight

        var ddddiifrork = System.currentTimeMillis() - frggt

        if (frgtgttimeeeeeeeeeeeetiememe % 700 < 10 + ftgtgt) {
            val maampamamapam = HashMap<String, Any>()

            maampamamapam["lane"] = (0..2).random()
            maampamamapam["startTime"] = frgtgttimeeeeeeeeeeeetiememe
            totototo.add(maampamamapam)
        }
        frgtgttimeeeeeeeeeeeetiememe = frgtgttimeeeeeeeeeeeetiememe + 10 + ftgtgt
        val ffffffcarvikded = gjtgtjtg / 5
        val defrfrcarHeighedefrfgtt = ffffffcarvikded + 10
        ppppppppppp1!!.style = Paint.Style.FILL

        //

        val ggggddddddd = resources.getDrawable(defrrmyCarfrrg, null)

        ggggddddddd.setBounds(
            edfrrrf5rr5 * gjtgtjtg / 3 + gjtgtjtg / 15 + 5,
            dfrfrrrr7 - 120 - defrfrcarHeighedefrfgtt,
            edfrrrf5rr5 * gjtgtjtg / 3 + gjtgtjtg / 15 + ffffffcarvikded - 25+50+60,
            dfrfrrrr7 - 20
        )
        ggggddddddd.draw(canvas!!)
        ppppppppppp1!!.color = Color.GREEN
        var ccccccccccsoreee = 0

        ffrrffrfr(canvas)


        if (ddddiifrork >= 5000) {
            enenenenen = enemyLogoListdfefrrf.random()
            frggt = System.currentTimeMillis()
            ftgtgt = ftgtgt + 1 + Math.abs(frfrrrr5def / 8)

            val mbmbmbmbmb = HashMap<String, Any>()
            mbmbmbmbmb["lane"] = (0..2).random()
            mbmbmbmbmb["startTime"] = frgtgttimeeeeeeeeeeeetiememe
            gtgtjt.add(mbmbmbmbmb)
        }


        for (i in totototo.indices) {
            try {
                val edfrgfrgtgt = totototo[i]["lane"] as Int * gjtgtjtg / 3 + gjtgtjtg / 15
                var frgttt = frgtgttimeeeeeeeeeeeetiememe - totototo[i]["startTime"] as Int


                val ddedfrkPodfrk = resources.getDrawable(enenenenen, null)

                ddedfrkPodfrk.setBounds(
                    edfrgfrgtgt + 25,
                    frgttt - defrfrcarHeighedefrfgtt,
                    edfrgfrgtgt + ffffffcarvikded,
                    frgttt
                )
                ddedfrkPodfrk.draw(canvas)
                if (totototo[i]["lane"] as Int == edfrrrf5rr5) {
                    if (frgttt > dfrfrrrr7 - 2 - defrfrcarHeighedefrfgtt && frgttt < dfrfrrrr7 - 2) {
                        Log.d("life", "life is ${fgtgtgtgt}")

                        when (fgtgtgtgt) {
                            0 -> {
                                gameTask1111.clclcllcgimi(frfrrrr5def)
                            }
                            1 -> {
                                gameTask1111.clclcllcgimi(frfrrrr5def)
                            }
                            2 -> {
                                tltltltlt = "1 ♥ left"
                                CoroutineScope(Dispatchers.Main).launch {
                                    delay(800)
                                    tltltltlt = ""
                                }
                                gtttg.color = Color.RED
                                fgtgtgtgt--
                                totototo.clear()
                            }
                            3 -> {
                                gtttg.color = Color.YELLOW
                                tltltltlt = "2 ♥ left"
                                CoroutineScope(Dispatchers.Main).launch {
                                    delay(800)
                                    tltltltlt = ""
                                }
                                myPaintLifeTextfrfrr5!!.alpha = 200
                                fgtgtgtgt--
                                totototo.clear()
                            }
                        }
                    }
                    if (frgttt > dfrfrrrr7 + defrfrcarHeighedefrfgtt) {
                        totototo.removeAt(i)
                        frfrrrr5def++
                        fgtgtgt++

                        if (frfrrrr5def > ccccccccccsoreee) {
                            ccccccccccsoreee = frfrrrr5def
                        }
                    }
                }

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }



        ppppppppppp1!!.color = Color.WHITE
        ppppppppppp1!!.textSize = 40f
        canvas.drawText("Score: $frfrrrr5def", 80f, dfrfrrrr7 - 40f, ppppppppppp1!!)
        canvas.drawText("Speed: $ftgtgt", 380f, dfrfrrrr7 - 40f, ppppppppppp1!!)
        canvas!!.drawRect(
            (gjtgtjtg - 200).toFloat(), dfrfrrrr7 - 40f,
            (gjtgtjtg - 200 + 60 * fgtgtgtgt).toFloat(), dfrfrrrr7 - 80f, gtttg
        )


        invalidate()
    }

    private fun ffrrffrfr(canvas: Canvas): Boolean {
        val ggggggggghjfgt = gjtgtjtg / 5
        val gktktokgt = ggggggggghjfgt + 10
        myPaintBonusdrfrrrfrgtt!!.style = Paint.Style.FILL

        for (i in gtgtjt.indices) {

            val bbobobofdgjggfgt = gtgtjt[i]["lane"] as Int * gjtgtjtg / 3 + gjtgtjtg / 15
            var frgttgt = frgtgttimeeeeeeeeeeeetiememe - gtgtjt[i]["startTime"] as Int

            val bombon = resources.getDrawable(R.drawable.heartbeat, null)
            bombon.setBounds(bbobobofdgjggfgt + 25, frgttgt - gktktokgt, bbobobofdgjggfgt + gktktokgt, frgttgt)
            bombon.draw(canvas)

            if (gtgtjt[i]["lane"] as Int == edfrrrf5rr5) {
                if (frgttgt > dfrfrrrr7 - 2 - gktktokgt && frgttgt < dfrfrrrr7 - 2) {
                    when (fgtgtgtgt) {
                        1 -> {
                            fgtgtgtgt++
                            tltltltlt = "2 ♥ left"
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(800)
                                tltltltlt = ""
                            }
                            gtttg.color = Color.YELLOW
                            gtgtjt.clear()
                            return true
                        }
                        2 -> {
                            fgtgtgtgt++
                            tltltltlt = "3 ♥ left"
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(800)
                                tltltltlt = ""
                            }
                            gtttg.color = Color.GREEN
                            gtgtjt.clear()
                            return true
                        }
                        3 -> {
                            tltltltlt = "MAX health"
                            CoroutineScope(Dispatchers.Main).launch {
                                delay(800)
                                tltltltlt = ""
                            }
                            return true
                        }
                    }
                }
            }
        }
        return true
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        try {
            when (event!!.action) {
                MotionEvent.ACTION_DOWN -> {
                    val gthhjyijhjiy = event.x
                    if (gthhjyijhjiy < gjtgtjtg / 2) {
                        if (edfrrrf5rr5 > 0) {
                            edfrrrf5rr5--
                        }
                    }
                    if (gthhjyijhjiy > gjtgtjtg / 2) {
                        if (edfrrrf5rr5 < 2) {
                            edfrrrf5rr5++
                        }
                    }
                    invalidate()
                }
                MotionEvent.ACTION_UP -> {

                }
            }
        } catch (e: Exception) {
            eeeeeeeeeeeeeri()
        }

        return true
    }

    private fun eeeeeeeeeeeeeri() {
        Snackbar.make(
            this,
            "Error, error, error...",
            Snackbar.LENGTH_LONG
        ).show()
    }




}

