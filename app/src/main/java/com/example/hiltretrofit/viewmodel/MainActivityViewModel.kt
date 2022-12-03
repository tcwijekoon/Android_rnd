package com.example.hiltretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltretrofit.network.RecyclerData
import com.example.hiltretrofit.network.Retrorepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val retrorepository : Retrorepository) : ViewModel(){

    var liveDataList : MutableLiveData<List<RecyclerData>> = MutableLiveData()

    fun getLivedataObserver() : MutableLiveData<List<RecyclerData>>{
        return liveDataList
    }

    fun loadListOfData(){
        retrorepository.makeApiCall("ny", liveDataList)
    }
}