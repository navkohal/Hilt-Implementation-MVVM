package com.example.hiltdemoapp

import androidx.lifecycle.MutableLiveData
import com.example.mydaggerdemo.di.RetorfitServiceInterface
import com.example.mydaggerdemo.model.ReposDataList
import com.example.mydaggerdemo.model.RepositoriesDataClass
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainActivityRepo @Inject constructor(private val retrofitServiceInterface: RetorfitServiceInterface){

    fun makeApiCall(query: String, liveDataList: MutableLiveData<List<ReposDataList>>){
        val call: Call<RepositoriesDataClass>? = retrofitServiceInterface.getRepositoriesApi(query)
        call?.enqueue(object : Callback<RepositoriesDataClass> {
            override fun onResponse(
                call: Call<RepositoriesDataClass>,
                response: Response<RepositoriesDataClass>
            ) {
                if(response.isSuccessful){
                    liveDataList.postValue(response.body()?.items)
                }else{
                    liveDataList.postValue(null)
                }
            }

            override fun onFailure(call: Call<RepositoriesDataClass>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }

}