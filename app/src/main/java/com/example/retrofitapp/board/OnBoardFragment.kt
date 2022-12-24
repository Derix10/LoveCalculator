package com.example.retrofitapp.board

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.FragmentOnBoardBinding
import com.example.retrofitapp.mvvm.ActivityMainViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardFragment : Fragment() {
    private lateinit var adapter : BoardAdapter
    private val viewModel: ActivityMainViewModel by viewModels()
    private lateinit var binding: FragmentOnBoardBinding
    private var currentPage = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BoardAdapter()
        binding.btnNext.setOnClickListener{
            findNavController().navigate(R.id.calculatorFragment)

            viewModel.saveBoardState()
        }

        binding.pagerOnBoard.adapter = adapter
        TabLayoutMediator(binding.mDots, binding.pagerOnBoard){_, _ -> }.attach()
        if (currentPage < 2){
            when(currentPage){
                0 -> binding.pagerOnBoard.currentItem = 0
                1 -> binding.pagerOnBoard.currentItem = 1
                2 -> binding.pagerOnBoard.currentItem = 2
            }
        }

        binding.pagerOnBoard.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                currentPage++

                if (position == 0) currentPage = 0
                if (position == 1) currentPage = 1
                if (position == 2 ){
                    binding.btnNext.visibility = View.VISIBLE
                }else{
                    binding.btnNext.visibility = View.INVISIBLE
                }
            }
        })

    }
}