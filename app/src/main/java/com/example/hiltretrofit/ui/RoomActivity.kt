package com.example.hiltretrofit.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.hiltretrofit.R
import com.example.hiltretrofit.viewmodel.RoomActicityModelView
import com.example.hiltroom.db.UserEntity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_room.*

@AndroidEntryPoint
class RoomActivity : AppCompatActivity() {

    lateinit var viewModel: RoomActicityModelView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        btnSave.setOnClickListener {
            val userEntity = UserEntity(name = editTextTextPersonName.text.toString())
            viewModel.insertRecord(userEntity)
            editTextTextPersonName.setText("")
        }
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(RoomActicityModelView::class.java)
        viewModel.getRecordObserver().observe(this
        ) { t ->
            tvDbValues.text = ""
            t?.forEach {
                tvDbValues.append(it.name + "\n")
            }
        }
    }
}