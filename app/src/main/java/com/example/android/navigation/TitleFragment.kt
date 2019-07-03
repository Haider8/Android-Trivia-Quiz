package com.example.android.navigation


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.*
import androidx.navigation.findNavController
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 *
 */
class TitleFragment : Fragment() {

    //Inflating and Returning the View with DataBindingUtil
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title,
                                                                    container, false)
        //Comment out the anonymous function below
//        binding.playButton.setOnClickListener {view: View ->
////            Navigation.findNavController(view).navigate(R.id.action_titleFragment_to_gameFragment)
//            view.findNavController().navigate(R.id.action_titleFragment_to_gameFragment)
//        }

        //Navigate can create On Click Listener for us!
        binding.playButton.setOnClickListener (
            createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        )

        return binding.root
    }
}