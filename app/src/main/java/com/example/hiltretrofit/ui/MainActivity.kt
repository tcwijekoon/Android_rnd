package com.example.hiltretrofit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hiltretrofit.R
import com.example.hiltretrofit.adaptor.RecyclerAdapter
import com.example.hiltretrofit.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView ()
        initViewModel()
    }

    fun initRecyclerView (){
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = RecyclerAdapter()
        recyclerView.adapter  = recyclerAdapter
    }


    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLivedataObserver().observe(this) {
            if (it != null) {
                recyclerAdapter.setListData(it)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.loadListOfData()
    }
}