package com.example.testableapproach.presentation.firstfragment.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.testableapproach.databinding.FfItemBinding
import com.example.testableapproach.domain.model.DomainUsersModel

class FirstFragmentItemViewHolder(
    private val vb: FfItemBinding,
    private val itemClickListener: ((DomainUsersModel) -> Unit)?
) :
    RecyclerView.ViewHolder(vb.root) {

    fun show(domainModel: DomainUsersModel) {
        vb.root.setOnClickListener { itemClickListener?.invoke(domainModel) }
        vb.ffItemTv.text = domainModel.login
    }
}