package com.pomelogames.bull

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.pomelogames.bull.databinding.FragmentStartyBinding
import com.pomelogames.bull.gggggrfrfr.GameTaskkkkkk
import com.pomelogames.bull.gggggrfrfr.GameVievvvvvvv


class StartyFragment : Fragment(), GameTaskkkkkk {
    private var bibibib: FragmentStartyBinding? = null
    private val btb get() = bibibib ?: throw RuntimeException("FragmentStartyBinding = null")

    val llllsgtggtfir = listOf(
        R.drawable.frgtttg,
        R.drawable.ftgtgtt,
    )

    private var rfrgttt55fr: GameVievvvvvvv? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        bibibib = FragmentStartyBinding.inflate(inflater, container, false)
        return btb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        try {

            btb.root.background.alpha = 200
            btb.btnStart.setOnClickListener {
                rfrgttt55fr =
                    GameVievvvvvvv(requireContext(), this, R.drawable.ojkuju, llllsgtggtfir)
                rfrgttt55fr!!.setBackgroundResource(R.drawable.gggg)
                rfrgttt55fr!!.background.alpha = 160
                btb.root.addView(rfrgttt55fr)
                btb.btnStart.visibility = View.GONE
                btb.tvScoreGame1.visibility = View.GONE
                btb.imgLogoGame1.visibility = View.GONE
            }
        } catch (e: Exception) {
            ffgttggt()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        bibibib = null
        super.onDestroy()
    }

    override fun clclcllcgimi(score: Int) {
        val scscscr = "Score : $score"
        btb.root.removeView(rfrgttt55fr)
        btb.tvScoreGame1.text = scscscr
        btb.btnStart.visibility = View.VISIBLE
        btb.tvScoreGame1.visibility = View.VISIBLE
        btb.imgLogoGame1.visibility = View.VISIBLE
        rfrgttt55fr = null

        findNavController().navigate(R.id.action_startyFragment_to_endyyyFragment)
    }

    private fun ffgttggt() {
        Snackbar.make(
            btb.root,
            "Error, error...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

}