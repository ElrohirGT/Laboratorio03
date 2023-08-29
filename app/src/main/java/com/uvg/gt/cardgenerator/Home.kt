package com.uvg.gt.cardgenerator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

/**
 * A simple [Fragment] subclass.
 * Use the [Home.newInstance] factory method to
 * create an instance of this fragment.
 */
class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_home, container, false)
        val btnBirthday = view.findViewById<Button>(R.id.home_btnHappyBirthday)
        val btnLove = view.findViewById<Button>(R.id.home_btnLoveCard)
        val btnFather = view.findViewById<Button>(R.id.home_btnHappyFathersDay)
        val btnMother = view.findViewById<Button>(R.id.home_btnHappyMothersDay)
        val btnGraduation = view.findViewById<Button>(R.id.home_btnGraduationCard)


        return view;
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment Home.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Home()
    }
}