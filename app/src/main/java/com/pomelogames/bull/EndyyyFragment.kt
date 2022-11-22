package com.pomelogames.bull

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.pomelogames.bull.databinding.FragmentEndyyyBinding


class EndyyyFragment : Fragment() {
    private var dfrgttgttfgt: FragmentEndyyyBinding? = null
    private val bindingfrgftrgtt5 get() = dfrgttgttfgt ?: throw RuntimeException("FragmentEndyyyBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dfrgttgttfgt = FragmentEndyyyBinding.inflate(inflater, container, false)
        return bindingfrgftrgtt5.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {

            bindingfrgftrgtt5.root.background.alpha = 200
            bindingfrgftrgtt5.btnExit.setOnClickListener {
                alerldleflrlftgtgtgt()
            }
            bindingfrgftrgtt5.btnTryAgain.setOnClickListener {
                requireActivity().onBackPressed()
            }

        } catch (e: Exception){
            efrfrgtgttg5ftgt()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        dfrgttgttfgt = null
        super.onDestroy()
    }

    private fun alerldleflrlftgtgtgt() {
        AlertDialog.Builder(requireContext())
            .setTitle("CLOSE")
            .setMessage("Please, do not close me, CLOSE?")
            .setPositiveButton("Yes, CLOSE") { _, _ ->
                requireActivity().onBackPressed()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }


    private fun efrfrgtgttg5ftgt() {
        Snackbar.make(
            bindingfrgftrgtt5.root,
            "Error, error, error",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


}