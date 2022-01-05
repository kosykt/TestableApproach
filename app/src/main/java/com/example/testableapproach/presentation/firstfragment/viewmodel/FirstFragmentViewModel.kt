package com.example.testableapproach.presentation.firstfragment.viewmodel

import androidx.lifecycle.ViewModel
import com.example.testableapproach.domain.GetUseCase

class FirstFragmentViewModel(
    private val getUseCase: GetUseCase
) : ViewModel() {

    private val _modelCount = getUseCase.execute()
    val modelCount = _modelCount
}