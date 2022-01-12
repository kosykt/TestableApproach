package com.example.testableapproach.presentation.firstfragment.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testableapproach.data.retrofit.ApiHolder
import com.example.testableapproach.data.retrofit.model.RetrofitModel
import com.example.testableapproach.domain.GetUseCase
import kotlinx.coroutines.launch
import retrofit2.Response

class FirstFragmentViewModel(
    private val getUseCase: GetUseCase
) : ViewModel() {

    private val retrofit = ApiHolder

    private val _modelCount = getUseCase.execute()
    val modelCount = _modelCount

    val test: MutableLiveData<Response<RetrofitModel>> = MutableLiveData()

    fun testRetrofit() {
        viewModelScope.launch {
            test.value = ApiHolder.apiService.getCashPayment()
            Log.d("testRetrofit", test.value.toString())
        }
    }
}