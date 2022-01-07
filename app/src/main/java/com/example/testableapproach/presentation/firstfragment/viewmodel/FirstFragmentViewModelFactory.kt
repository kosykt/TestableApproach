package com.example.testableapproach.presentation.firstfragment.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testableapproach.data.DomainRepositoryImpl
import com.example.testableapproach.data.storage.StorageObject
import com.example.testableapproach.domain.GetUseCase

class FirstFragmentViewModelFactory(application: Application) : ViewModelProvider.Factory {

    private val domainRepository = DomainRepositoryImpl(
        repository = StorageObject,
        application = application
    )
    private val getUseCase = GetUseCase(repository = domainRepository)

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return FirstFragmentViewModel(getUseCase) as T
    }
}
