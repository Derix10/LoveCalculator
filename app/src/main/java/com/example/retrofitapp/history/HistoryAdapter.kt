package com.example.retrofitapp.history

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.databinding.ItemHistoryBinding
import com.example.retrofitapp.mvvm.CalculateModel

class HistoryAdapter: RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    lateinit var list : List<CalculateModel>

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(calculateModel: CalculateModel) {
            binding.tvHistoryYou.text = calculateModel.secondName
            binding.tvHistoryMe.text = calculateModel.firstName
            binding.percentageHistory.text = "${calculateModel.percentage} %"
        }

    }
    fun addNewGroup(list: List<CalculateModel>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount() = list.size
}