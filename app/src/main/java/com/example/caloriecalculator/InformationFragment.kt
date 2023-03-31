package com.example.caloriecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.caloriecalculator.databinding.FragmentInformationBinding
import com.example.caloriecalculator.model.SharedViewModel

class InformationFragment : Fragment() {
    private var binding : FragmentInformationBinding? = null
    private val sharedViewModel : SharedViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_information, container, false)
        val fragmentBinding = FragmentInformationBinding.inflate(inflater,container,false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.apply {
            viewModel = sharedViewModel
            informationFragment = this@InformationFragment
            lifecycleOwner = viewLifecycleOwner
        }
    }

    override fun onResume() {
        super.onResume()
        val activeDays = resources.getStringArray(R.array.active_days)
        val activeDaysAdapter = ArrayAdapter(requireContext(),R.layout.dropdown_active_days, activeDays)
        binding!!.autoCompleteTextView.setAdapter(activeDaysAdapter)
    }

    fun goToNextScreen(){
        val age = binding?.ageEditText?.text.toString().toInt()
        sharedViewModel.setAge(age)

        val height = binding?.heightEditText?.text.toString().toDouble()
        sharedViewModel.setHeight(height)

        val weight = binding?.weightEditText?.text.toString().toDouble()
        sharedViewModel.setWeight(weight)

        val activeDays = binding!!.autoCompleteTextView.text.toString()
        sharedViewModel.setActiveDays(activeDays)

        findNavController().navigate(R.id.action_informationFragment2_to_resultFragment2)
    }

}