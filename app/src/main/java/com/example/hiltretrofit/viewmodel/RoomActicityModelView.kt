package com.example.hiltretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.hiltretrofit.network.Retrorepository
import com.example.hiltroom.db.UserEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomActicityModelView @Inject constructor(private val repository: Retrorepository)  : ViewModel(){

    lateinit var userData: MutableLiveData<List<UserEntity>>

    init {
        userData = MutableLiveData()
    }

    fun getRecordObserver () : MutableLiveData<List<UserEntity>> {
        return userData
    }

    fun loadRecord(){
        val list = repository.getRecords()
        userData.postValue(list)
    }

    fun insertRecord (userEntity: UserEntity) {
        repository.insertRecord(userEntity)
        loadRecord()
    }

}