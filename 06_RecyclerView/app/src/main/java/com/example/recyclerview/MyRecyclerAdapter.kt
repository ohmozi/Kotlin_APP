package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyRecyclerAdapter(myRecyclerviewInterface: MyRecyclerviewInterface): RecyclerView.Adapter<MyViewHolder>() {

    val TAG: String = "로그"

    private var modelList = ArrayList<MyModel>()

    private var myRecyclerviewInterface :MyRecyclerviewInterface? = null

    // 생성자
    init{
        this.myRecyclerviewInterface = myRecyclerviewInterface
    }
    // 뷰홀더가 생성되었을 때
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        // 연결할 레이아웃 설정
        // inflate : 레이아웃과 연결시켜줌
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recycler_item, parent, false),
                this.myRecyclerviewInterface!!) // 느낌표 두개는 꼭 값이 있을 것이다 설명
    }

    // 목록의 아이템 수
    override fun getItemCount(): Int {
        return this.modelList.size
    }

    // 뷰와 뷰홀더가 묶였을 때 ( 1. 클릭리스너 설정할수도있음 / 2. 인터페이스를 이용해서 설정할수있음(이걸로 진행) )
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d(TAG, "MyRecyclerAdapter - onBindViewHolder() called / position : $position")
        holder.bind(this.modelList[position])

//        // 클릭리스너 설정
//        holder.itemView.setOnClickListener{
//            // 간단하게 토스트 메시지 출력
//            Toast.makeText(App.instance, "클릭됨! ${this.modelList[position].name}", Toast.LENGTH_SHORT).show()
//        }
    }

    fun submitList(modelList: ArrayList<MyModel>){
        this.modelList = modelList
    }
}