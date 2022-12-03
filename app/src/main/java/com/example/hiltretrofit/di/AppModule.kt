package com.example.hiltretrofit.di

import android.app.Application
import com.example.hiltretrofit.network.RetroServiceInstance
import com.example.hiltroom.db.AppDao
import com.example.hiltroom.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    var base_url = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun getRetroServiceInstance (retrofit: Retrofit) : RetroServiceInstance {
        return retrofit.create(RetroServiceInstance ::class.java)
    }

    @Singleton
    @Provides
    fun getRetroInstance() : Retrofit{
        return Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun getAppDB (context: Application) : AppDatabase {
        return AppDatabase.getAppDB(context)
    }

    @Singleton
    @Provides
    fun getDao(appDb : AppDatabase) : AppDao {
        return appDb.getDAO()
    }

}