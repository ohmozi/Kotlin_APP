package com.example.recyclerview

import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_recycler_item.view.*

// 커스텀 뷰홀더
class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val TAG: String = "로그"

    private val usernameTextView = itemView.user_name_txt
    private val profileImageView = itemView.profile_img

    init {
        Log.d(TAG, "MyVeiwHolder - () called")
    }

    // 데이터와 뷰를 묶는다.
    fun bind(myModel: MyModel){
        Log.d(TAG, "MyVeiwHolder - bind() called")

        // 텍스트뷰와 실제 텍스트 데이터를 묶는다.
        usernameTextView.text = myModel.name

        // 이미지뷰와 실제 이미지 데이터를 묶는다. -> Glide라는 오픈소스 사용 (인터넷 url접속후 이미지 따옴)
        Glide
            .with(App.instance)     // 전역선언한 컨텍스트를 가져온다
            .load(myModel.profileImage)
//            .centerCrop()
            .placeholder(R.mipmap.ic_launcher)        // 가져온 이미지가 없다면 띄워줄 그림
            .into(profileImageView)
    }
}