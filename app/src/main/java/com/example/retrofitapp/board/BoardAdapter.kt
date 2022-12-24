package com.example.retrofitapp.board

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitapp.R
import com.example.retrofitapp.databinding.ItemOnBoardBinding

class BoardAdapter : RecyclerView.Adapter<BoardAdapter.BoardViewHolder>() {
    val titleList = listOf(
        "Have a good time",
        "Cherishing love",
        "Have a breakup")

    val decsList = listOf(
        "You should take the time to help those \n who need you",
        "It is now no longer possible for \n you to cherish love",
        "We have made the correction for you \n don't worry \n Maybe someone is waiting for you!")


    val imgList = listOf(R.drawable.img_2, R.drawable.img, R.drawable.img_3)


    inner class BoardViewHolder(val binding: ItemOnBoardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(position: Int) {
            binding.imgBoardItem.setBackgroundResource(imgList[position])
            binding.tvTitleBoardItem.text = titleList[position]
            binding.tvDesBoardItem.text = decsList[position]
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BoardViewHolder {
        val binding = ItemOnBoardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BoardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BoardViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount() = titleList.size
}