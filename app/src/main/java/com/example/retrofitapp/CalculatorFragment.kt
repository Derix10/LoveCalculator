package com.example.retrofitapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.retrofitapp.databinding.FragmentCalculatorBinding

class CalculatorFragment : Fragment() {
   private lateinit var binding: FragmentCalculatorBinding
   private lateinit var controller: NavController
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHost = requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHost.navController
        binding.btnCalculate.setOnClickListener {
            controller.navigate(
                CalculatorFragmentDirections.actionCalculatorFragmentToResultFragment(binding.you.text.toString(), binding.me.text.toString())
                )

        }
    }


}