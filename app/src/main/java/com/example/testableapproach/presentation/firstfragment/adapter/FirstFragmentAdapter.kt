package com.example.testableapproach.presentation.firstfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testableapproach.databinding.FfItemBinding
import com.example.testableapproach.domain.DomainModel

class FirstFragmentAdapter() :
    ListAdapter<DomainModel, FirstFragmentItemViewHolder>(FirstFragmentDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstFragmentItemViewHolder {
        return FirstFragmentItemViewHolder(
            FfItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FirstFragmentItemViewHolder, position: Int) {
        holder.show(currentList[position])
    }
}