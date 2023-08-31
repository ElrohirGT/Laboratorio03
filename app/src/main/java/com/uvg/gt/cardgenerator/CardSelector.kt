package com.uvg.gt.cardgenerator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.core.view.get
import androidx.navigation.fragment.findNavController

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
const val ARG_CATEGORY_NAME = "categoria"

/**
 * A simple [Fragment] subclass.
 * Use the [CardSelector.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardSelector : Fragment() {
    private var categoria: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            categoria = it.getString(ARG_CATEGORY_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_card_selector, container, false)

        //val view= inflater.inflate(R.layout.fragment_birthday_card, container, false)
        val cont=view.findViewById<FrameLayout>(R.id.card_selector_container)
        val img=cont.findViewById<ImageButton>(R.id.birthday_image_button)
        val btnVolver = view.findViewById<Button>(R.id.back_button)
        btnVolver.setOnClickListener{
            val controller = findNavController();
            controller.navigate(R.id.action_cardSelector_to_home2)
        }
        /*
        img.setOnClickListener{
            val controller = findNavController();
            controller.navigate(R.id.action_cardSelector_to_home2)
        }
        */
        // Retrieve the container
        val container = view.findViewById<FrameLayout>(R.id.card_selector_container)

        // Check the selected category and replace with the appropriate fragment
        when (categoria) {
            CardCategories.Birthday.toString() -> {
                val birthdayFragment = BirthdayCardFragment.newInstance()
                childFragmentManager.beginTransaction()
                    .replace(R.id.card_selector_container, birthdayFragment)
                    .commit()

            }
            CardCategories.Love.toString() -> {
                val loveFragment = LoveCardFragment.newInstance()
                childFragmentManager.beginTransaction()
                    .replace(R.id.card_selector_container, loveFragment)
                    .commit()
            }
            CardCategories.Halloween.toString() -> {
                val halloweenFragment = HalloweenCardFragment.newInstance()
                childFragmentManager.beginTransaction()
                    .replace(R.id.card_selector_container, halloweenFragment)
                    .commit()
            }
            CardCategories.NewYear.toString() -> {
                val newYearFragment = NewYearCardFragment.newInstance()
                childFragmentManager.beginTransaction()
                    .replace(R.id.card_selector_container, newYearFragment)
                    .commit()
            }
            CardCategories.Christmas.toString() -> {
                val christmasFragment = ChristmasCardFragment.newInstance()
                childFragmentManager.beginTransaction()
                    .replace(R.id.card_selector_container, christmasFragment)
                    .commit()
            }
        }

        return view
    }
    class BirthdayCardFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_birthday_card, container, false)
        }

        companion object {
            fun newInstance() = BirthdayCardFragment()
        }
    }

    class LoveCardFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_love_card, container, false)
        }

        companion object {
            fun newInstance() = LoveCardFragment()
        }
    }
    class HalloweenCardFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_halloween_card, container, false)
        }

        companion object {
            fun newInstance() = HalloweenCardFragment()
        }
    }
    class NewYearCardFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_new_year_card, container, false)
        }

        companion object {
            fun newInstance() = NewYearCardFragment()
        }
    }
    class ChristmasCardFragment : Fragment() {
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            // Inflate the layout for this fragment
            return inflater.inflate(R.layout.fragment_christmas_card, container, false)
        }

        companion object {
            fun newInstance() = ChristmasCardFragment()
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param categoryName The name of the category of card to select.
         * @return A new instance of fragment CardSelector.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(categoryName: CardCategories) =
            CardSelector().apply {
                arguments = Bundle().apply {
                    putString(ARG_CATEGORY_NAME, categoryName.toString())
                }
            }
    }
}