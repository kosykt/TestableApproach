package com.example.testableapproach.presentation.firstfragment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testableapproach.data.retrofit.ApiHolder
import com.example.testableapproach.domain.GetUseCase
import com.example.testableapproach.domain.model.DomainUsersModel
import kotlinx.coroutines.launch

class FirstFragmentViewModel(
    private val getUseCase: GetUseCase
) : ViewModel() {

    private val _usersList = MutableLiveData<List<DomainUsersModel>>()
    val usersList: MutableLiveData<List<DomainUsersModel>>
        get() = _usersList

    fun getUsersFromNetwork(){
        _usersList.value = getUseCase.execute()
        testRetrofit()
    }

    fun testRetrofit() {
        viewModelScope.launch {
            val a = ApiHolder.retrofitService.getTest()
            Log.d("testRetrofit", a.isSuccessful.toString())
        }
    }
}