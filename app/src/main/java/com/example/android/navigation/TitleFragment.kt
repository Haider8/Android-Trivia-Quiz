package com.example.android.navigation


import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.Navigation.*
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
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

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        //happens when we select an item from the menu
        return NavigationUI.onNavDestinationSelected(item!!,
                view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        //create over flow menu
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.overflow_menu, menu)
    }
}
