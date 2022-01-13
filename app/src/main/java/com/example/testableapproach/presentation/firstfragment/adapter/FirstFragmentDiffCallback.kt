package com.example.testableapproach.presentation.firstfragment.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.testableapproach.domain.model.DomainUsersModel

class FirstFragmentDiffCallback : DiffUtil.ItemCallback<DomainUsersModel>() {
    override fun areItemsTheSame(oldItem: DomainUsersModel, newItem: DomainUsersModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: DomainUsersModel, newItem: DomainUsersModel): Boolean {
        return oldItem == newItem
    }
}