package com.example.testableapproach.presentation.firstfragment.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testableapproach.data.DomainRepositoryImpl
import com.example.testableapproach.data.retrofit.ApiHolder
import com.example.testableapproach.data.retrofit.NetworkRepositoryImpl
import com.example.testableapproach.domain.GetUseCase

class FirstFragmentViewModelFactory(application: Application) : ViewModelProvider.Factory {

    private val retrofitService = ApiHolder.retrofitService
    private val networkRepository = NetworkRepositoryImpl(retrofitService = retrofitService)
    private val domainRepository = DomainRepositoryImpl(networkRepository = networkRepository)
    private val getUseCase = GetUseCase(repository = domainRepository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return FirstFragmentViewModel(getUseCase = getUseCase) as T
    }
}
