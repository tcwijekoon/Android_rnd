package com.example.hiltretrofit.network

import androidx.lifecycle.MutableLiveData
import com.example.hiltroom.db.AppDao
import com.example.hiltroom.db.UserEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class Retrorepository @Inject constructor(private val retroServiceInstance: RetroServiceInstance, private val appDao: AppDao){

    fun makeApiCall (query: String , liveDataList : MutableLiveData<List<RecyclerData>>){
        val call : Call<RecyclerList> = retroServiceInstance.getDtaFromApi(query)
        call?.enqueue(object  : Callback<RecyclerList>{
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                liveDataList.postValue(response.body()?.items!!)
            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                liveDataList.postValue(null)
            }
        })
    }


    fun getRecords() : List<UserEntity> {
        return appDao.getRecords()
    }

    fun insertRecord(userEntity: UserEntity){
        appDao.insertRecords(userEntity)
    }
}