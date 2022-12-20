package com.example.retrofitapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.retrofitapp.databinding.FragmentCalculatorBinding
import retrofit2.Call
import retrofit2.Response

class CalculatorFragment : Fragment() {
    private val viewModel: ActivityMainViewModel by viewModels()
    private lateinit var binding: FragmentCalculatorBinding

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
        binding.btnCalculate.setOnClickListener {
            makeRequest()
        }
    }

    private fun makeRequest() {
        viewModel.makeRequest(
            binding.me.text.toString(),
            binding.you.text.toString()
        ).observe(viewLifecycleOwner) {
            findNavController().navigate(
                CalculatorFragmentDirections
                    .actionCalculatorFragmentToResultFragment(it)
            )
        }
    }

}