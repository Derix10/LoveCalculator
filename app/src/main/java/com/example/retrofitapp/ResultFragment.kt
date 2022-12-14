package com.example.retrofitapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.navArgs
import com.example.retrofitapp.databinding.FragmentResultBinding
import retrofit2.Call
import retrofit2.Response

class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private lateinit var controller: NavController
    private val args by navArgs<ResultFragmentArgs>()
    private val fname by lazy { args.fname }
    private val sname by lazy { args.sname }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        get()
        val navHost =
            requireActivity().supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        controller = navHost.navController

            binding.secondYou.text = fname
            binding.secondMe.text = sname

        binding.btnTryAgain.setOnClickListener{
            controller.navigate(R.id.calculatorFragment)
        }


    }

    private fun get() {
        App.api.getPercentage(fname, sname)
            .enqueue(
                object : retrofit2.Callback<CalculateModel> {
                    @SuppressLint("SetTextI18n")
                    override fun onResponse(
                        call: Call<CalculateModel>,
                        response: Response<CalculateModel>
                    ) {
                        binding.percentage.text = "${response.body()?.percentage} %"
                        binding.yourScore.text = response.body()?.result
                    }

                    override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                    }


                }
            )

    }
}