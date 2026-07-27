package com.suresh.task2splashscreen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.suresh.task2splashscreen.databinding.ItemOnBoardingBinding
import com.suresh.task2splashscreen.model.OnBoardingData

class OnBoardingAdapter(
    private val list: List<OnBoardingData>
) : RecyclerView.Adapter<OnBoardingAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemOnBoardingBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        holder.binding.imgOnBoard.setImageResource(item.image)
        holder.binding.txtTitle.text = item.title
        holder.binding.txtDescription.text = item.description
    }
}