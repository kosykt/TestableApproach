package com.example.testableapproach.presentation.firstfragment.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.testableapproach.databinding.FfItemBinding
import com.example.testableapproach.domain.DomainModel

class FirstFragmentItemViewHolder(
    private val vb: FfItemBinding,
    private val itemClickListener: ((DomainModel) -> Unit)?
) :
    RecyclerView.ViewHolder(vb.root) {

    fun show(domainModel: DomainModel) {
        vb.root.setOnClickListener { itemClickListener?.invoke(domainModel) }
        vb.ffItemTv.text = domainModel.count.toString()
    }
}