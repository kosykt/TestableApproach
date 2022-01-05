package com.example.testableapproach.presentation.firstfragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testableapproach.domain.DomainModel

class FirstFragmentDiffCallback : DiffUtil.ItemCallback<DomainModel>() {
    override fun areItemsTheSame(oldItem: DomainModel, newItem: DomainModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DomainModel, newItem: DomainModel): Boolean {
        return oldItem == newItem
    }
}