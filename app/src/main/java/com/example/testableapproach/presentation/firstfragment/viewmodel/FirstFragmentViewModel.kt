package com.example.testableapproach.presentation.firstfragment.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.testableapproach.data.retrofit.ApiHolder
import com.example.testableapproach.data.retrofit.model.RetrofitModel
import com.example.testableapproach.domain.GetUseCase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FirstFragmentViewModel(
    private val getUseCase: GetUseCase
) : ViewModel() {

    private val retrofit = ApiHolder

    private val _modelCount = getUseCase.execute()
    val modelCount = _modelCount

    fun testRetrofit() {
        retrofit.apiService.getCashPayment().enqueue(object :
            Callback<RetrofitModel> {
            override fun onResponse(call: Call<RetrofitModel>, response: Response<RetrofitModel>) {
                if (response.isSuccessful && response.body() != null) {
                    val asd = response.body()
                    Log.d("testRetrofit", asd.toString())
                } else {
                    val message = response.message()
                    if (message.isNullOrEmpty()) {
                        Log.d("testRetrofit", message)
                    } else {
                        Log.d("testRetrofit", message)
                    }
                }
            }

            override fun onFailure(call: Call<RetrofitModel>, t: Throwable) {
                Log.d("testRetrofit", t.message.toString())
            }
        }
        )
    }
}