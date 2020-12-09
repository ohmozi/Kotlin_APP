package com.example.a09_myviewpager2introslide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*
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

        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        // Remember that you should never show the action bar if the
        // status bar is hidden, so hide that too if necessary.
        actionBar?.hide()

        // 화살표 누르면 처리
        previous_btn.setOnClickListener{
            Log.d(TAG, "MainActivity - 이전 버튼 클릭")

            my_intro_view_pager.currentItem = my_intro_view_pager.currentItem - 1
        }
        next_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 다음 버튼 클릭")

            my_intro_view_pager.currentItem = my_intro_view_pager.currentItem + 1
        }

        // 데이터 배열을 준비
        pageItemList.add(PageItem(R.color.colorOrange
            , R.drawable.ic_pager_item_1, R.drawable.ic_pager_item_2, "안녕하세요!\n 개발하는 오모지입니다~"))

        pageItemList.add(PageItem(R.color.colorBlue
            , R.drawable.ic_pager_item_3, R.drawable.ic_pager_item_4, "오늘도 빡코딩 하시나요?"))

        pageItemList.add(PageItem(R.color.colorWhite
            , R.drawable.ic_pager_item_5, R.drawable.ic_pager_item_6, "좋은하루 되세요~"))

        // 어답터 인스턴스 생성
        myIntroPagerRecyclerAdapter = MyIntroPagerRecyclerAdapter(pageItemList)

        my_intro_view_pager.apply{
            adapter = myIntroPagerRecyclerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL

            // 닷 인디케이터 오픈소스 적용
            dots_indicator.setViewPager2(this)
//            val dotsIndicator = findViewById<WormDotsIndicator>(R.id.dots_indicator)
//            val viewPager = findViewById<ViewPager>(R.id.view_pager)
//            val adapter = ViewPagerAdapter()
//            viewPager.adapter = adapter
//            dotsIndicator.setViewPager(viewPager)
        }

        // 이 두줄을 계속 하기 귀찮으니까 apply에서 바로 설정
//        my_intro_view_pager.adapter = myIntroPagerRecyclerAdapter
//        my_intro_view_pager.orientation = ViewPager2.ORIENTATION_HORIZONTAL

    }
}