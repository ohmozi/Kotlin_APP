package com.example.layoutpractice

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter: RecyclerView.Adapter<MyViewHolder>() {

    val TAG: String = "로그"

    private var modelList = ArrayList<MyModel>()

    // 뷰홀더가 생성되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        // 연결할 레이아웃 설정
        // inflate : 레이아웃과 연결시켜줌
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent, false))
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return this.modelList.size
    }

    // 뷰와 뷰홀더가 묶였을 때
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position : $position")
        holder.bind(this.modelList[position])
    }

    fun submitList(modelList: ArrayList<MyModel>){
        this.modelList = modelList
    }
}