package com.example.caloriecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.caloriecalculator.databinding.FragmentResultBinding
import com.example.caloriecalculator.model.SharedViewModel

class ResultFragment : Fragment() {
    private var binding : FragmentResultBinding? = null
    private val sharedViewModel : SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //       return inflater.inflate(R.layout.fragment_result, container, false)
        val fragmentBinding = FragmentResultBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            resultFragment = this@ResultFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

    fun goToNextScreen(){
        findNavController().navigate(R.id.action_resultFragment_to_informationFragment2)
    }


}