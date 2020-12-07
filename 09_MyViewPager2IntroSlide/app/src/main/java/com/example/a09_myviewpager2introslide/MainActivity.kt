package com.example.a09_myviewpager2introslide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG: String = "로그"
    }

    // 데이터 배열 선언
    private var pageItemList =  ArrayList<PageItem>()
    private lateinit var myIntroPagerRecyclerAdapter: MyIntroPagerRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        // 데이터 배열을 준비
        pageItemList.add(PageItem(R.color.colorOrange
            , R.drawable.ic_pager_item_1, R.drawable.ic_pager_item_2, "안녕하세요!\n 개발하는 오모지입니다~"))

        pageItemList.add(PageItem(R.color.colorBlue
            , R.drawable.ic_pager_item_3, R.drawable.ic_pager_item_4, "오늘도 빡코딩 하시나요?"))

        pageItemList.add(PageItem(R.color.colorWhite
            , R.drawable.ic_pager_item_5, R.drawable.ic_pager_item_6, "좋은하루 되세요~"))

        // 어답터 인스턴스 생성
        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)
    }
}