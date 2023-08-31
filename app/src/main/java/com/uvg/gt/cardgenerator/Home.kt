package com.uvg.gt.cardgenerator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

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
        val btnChristmas = view.findViewById<Button>(R.id.home_btnChristmas)
        val btnNewYear = view.findViewById<Button>(R.id.home_btnNewYear)
        val btnHalloween = view.findViewById<Button>(R.id.home_btnHalloween)

        btnBirthday.setOnClickListener {
            //navigateToCardSelect(CardCategories.Birthday)
            val controller = findNavController();
            controller.navigate(R.id.action_home2_to_birthdayCard)
        }
        btnLove.setOnClickListener {
           // navigateToCardSelect(CardCategories.Love)
            val controller = findNavController();
            controller.navigate(R.id.action_home2_to_loveCard)
        }
        btnChristmas.setOnClickListener {
            //navigateToCardSelect(CardCategories.Christmas)
            val controller = findNavController();
            controller.navigate(R.id.action_home2_to_christmasCard)
        }
        btnNewYear.setOnClickListener {
            //navigateToCardSelect(CardCategories.NewYear)
            val controller = findNavController();
            controller.navigate(R.id.action_home2_to_newYearCard)
        }
        btnHalloween.setOnClickListener {
            //navigateToCardSelect(CardCategories.Halloween)
            val controller = findNavController();
            controller.navigate(R.id.action_home2_to_halloweenCard)
        }


        return view;
    }

    fun navigateToCardSelect(category: CardCategories) {
        val controller = findNavController();
        controller.navigate(R.id.action_home2_to_cardSelector, Bundle().apply{
            putString(ARG_CATEGORY_NAME, category.toString())
        })
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