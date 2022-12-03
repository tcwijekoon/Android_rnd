package com.example.hiltretrofit.adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hiltretrofit.R
import com.example.hiltretrofit.network.RecyclerData
import com.example.hiltretrofit.ui.RoomActivity
import kotlinx.android.synthetic.main.recytler_item.view.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.MyHolder>() {

    private var listData : List<RecyclerData>? = null

    fun setListData( listData : List<RecyclerData>?){
        this.listData = listData
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recytler_item, parent, false)
        return MyHolder(view, parent.context)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(listData!![position])
    }

    override fun getItemCount(): Int {
        if(listData == null )return 0
        return listData?.size!!
    }

    class MyHolder (view : View, private val context: Context) : RecyclerView.ViewHolder(view) {

        fun bind(data : RecyclerData){
            itemView.tv1.text = data.name
            itemView.tv2.text = data.description

            Glide.with(itemView.iv1)
                .load(data.owner!!.avatar_url)
                .into(itemView.iv1)

            itemView.setOnClickListener{
                Intent(context, RoomActivity::class.java).apply {
                    context.startActivity(this)
                }
            }
        }
    }
}