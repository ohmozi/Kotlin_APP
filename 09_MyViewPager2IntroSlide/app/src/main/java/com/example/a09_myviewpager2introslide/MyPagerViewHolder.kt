package com.example.a09_myviewpager2introslide

import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_intro_pager_item.view.*

class MyPagerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val itemBackground : LinearLayout = itemView.pager_item_bg
    private val itemImageLeft : ImageView = itemView.pager_item_image_left
    private val itemImageRight : ImageView = itemView.pager_item_image_right
    private val itemContent : TextView = itemView.pager_item_text

    // 데이터랑 뷰를 연결
    fun bindWithView(pageItem: PageItem){
        itemImageLeft.setImageResource(pageItem.imageSrcLeft)
        itemImageRight.setImageResource(pageItem.imageSrcRight)
        itemContent.text = pageItem.content

        itemBackground.setBackgroundResource(pageItem.bgColor)
    }


}