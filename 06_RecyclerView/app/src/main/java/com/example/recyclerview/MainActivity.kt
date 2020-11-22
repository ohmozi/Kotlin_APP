package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG: String = "로그"

    // 데이터를 담을 그릇 즉 배열
    var modelList = ArrayList<MyModel>()

    // 리사이클러뷰에 연결할 어댑터를 선언해야한다
    private lateinit var myRecyclerAdapter: MyRecyclerAdapter

    // 뷰가 화면에 그려질 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "Main04 - onCreate() called")

        for(i in 1..10){
            val myModel = MyModel(name="오모지 $i", profileImage = "chrome://favicon2/?size=24&scale_factor=1x&show_fallback_monogram=&page_url=https%3A%2F%2Fwww.naver.com%2F")
            this.modelList.add(myModel)
        }

        // 어댑터 인스턴스 생성
        myRecyclerAdapter = MyRecyclerAdapter()

        myRecyclerAdapter.submitList(this.modelList)

        // 리사이클러뷰 설정 : layoutmanager를 통해 정렬방법, 렌더링 방법 등을 설정할수있다.
        my_recycler_view.apply {
            //
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)

            // 어댑터 장착
            adapter = myRecyclerAdapter
        }
    }
}