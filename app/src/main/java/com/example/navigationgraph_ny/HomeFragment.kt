package com.example.navigationgraph_ny

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navOptions

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val option = navOptions {
            anim {
                enter = R.anim.slide_in_right
                popEnter = R.anim.slide_in_left
                exit = R.anim.slide_out_left
                popExit = R.anim.slide_out_right
            }
        }
        val buttonDestination = view.findViewById<Button>(R.id.navigateWithDestination)
        buttonDestination.setOnClickListener {
            findNavController().navigate(R.id.firstFragment, null, option)
        }

        val buttonAction = view.findViewById<Button>(R.id.navigateWithAction)
        buttonAction.setOnClickListener {
//            findNavController().navigate(R.id.action_homeFragment_to_firstFragment)
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToFirstFragment())
        }
    }
}