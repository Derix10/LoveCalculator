package com.example.retrofitapp.history

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.retrofitapp.App
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {
    private lateinit var binding: FragmentHistoryBinding
    private lateinit var adapter: HistoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = HistoryAdapter()
        adapter.addNewGroup(App.db.historyDao().getAllFromHistory())
        binding.rvHistory.adapter = adapter
        binding.homeHistory.setOnClickListener{
            findNavController().navigate(R.id.calculatorFragment)
        }

    }
}