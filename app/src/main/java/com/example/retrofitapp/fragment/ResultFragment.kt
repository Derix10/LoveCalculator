package com.example.retrofitapp.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.retrofitapp.App
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.FragmentResultBinding
import com.example.retrofitapp.mvvm.CalculateModel


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

        App.db.historyDao().addToHistory(CalculateModel(
            firstName = fname,
            secondName = sname,
            percentage = percentage
        ))
        binding.btnTryAgain.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.seocndHistory.setOnClickListener{

            findNavController().navigate(R.id.historyFragment)
        }

    }
}