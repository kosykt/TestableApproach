package com.example.testableapproach.presentation.firstfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testableapproach.domain.GetUseCase

class FirstFragmentViewModel(
    private val getUseCase: GetUseCase
) : ViewModel() {

    private val _modelCount = MutableLiveData<String>()
    val modelCount: MutableLiveData<String>
        get() = _modelCount

    fun load(){
        _modelCount.value = getUseCase.execute().count.toString()
    }
}