package com.example.hiltdemoapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydaggerdemo.model.ReposDataList
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val mainActivityRepo: MainActivityRepo) : ViewModel() {

    lateinit var livedatalist : MutableLiveData<List<ReposDataList>>

    init {
        livedatalist = MutableLiveData()
    }

    fun getLiveDataObserver() : MutableLiveData<List<ReposDataList>>{
        return livedatalist
    }

    fun loadListofData(){
        mainActivityRepo.makeApiCall("ny",livedatalist)
    }

}