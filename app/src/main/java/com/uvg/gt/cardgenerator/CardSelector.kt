package com.uvg.gt.cardgenerator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

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
        return inflater.inflate(R.layout.fragment_card_selector, container, false)
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