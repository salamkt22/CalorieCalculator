package com.example.caloriecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.caloriecalculator.databinding.FragmentStartBinding
import com.example.caloriecalculator.model.SharedViewModel

class StartFragment : Fragment() {
    private var binding : FragmentStartBinding? = null
    private val sharedViewModel : SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_start, container, false)
        val fragmentBinding = FragmentStartBinding.inflate(inflater, container , false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            startFragment = this@StartFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

    fun goToNextScreen(){
        val gymName = binding?.nameEnterEditText?.text.toString()
        sharedViewModel.setGender(gymName)

        findNavController().navigate(R.id.action_startFragment2_to_informationFragment2)
    }

}