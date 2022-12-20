package com.example.retrofitapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.retrofitapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private val args by navArgs<ResultFragmentArgs>()
    private val fname by lazy { args.model.firstName }
    private val sname by lazy { args.model.secondName }
    private val yourScore by lazy { args.model.result }
    private val percentage by lazy { args.model.percentage }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }


    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.secondYou.text = fname
        binding.secondMe.text = sname
        binding.yourScore.text = yourScore
        binding.percentage.text = "$percentage %"

        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}