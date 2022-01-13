package com.example.testableapproach.presentation.firstfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.testableapproach.databinding.FfItemBinding
import com.example.testableapproach.domain.model.DomainUsersModel

class FirstFragmentAdapter() :
    ListAdapter<DomainUsersModel, FirstFragmentItemViewHolder>(FirstFragmentDiffCallback()) {

    var itemClickListener: ((DomainUsersModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstFragmentItemViewHolder {
        return FirstFragmentItemViewHolder(
            FfItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            itemClickListener = itemClickListener
        )
    }

    override fun onBindViewHolder(holder: FirstFragmentItemViewHolder, position: Int) {
        holder.show(currentList[position])
    }
}