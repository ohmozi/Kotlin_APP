package com.example.a09_myviewpager2introslide

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main.*


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
            Log.d(TAG, "before currentItem : ${my_intro_view_pager.currentItem}")
            my_intro_view_pager.currentItem = (my_intro_view_pager.currentItem + (pageItemList.size-1)) % pageItemList.size
            Log.d(TAG, "after currentItem : ${my_intro_view_pager.currentItem}")

        }
        next_btn.setOnClickListener {
            Log.d(TAG, "MainActivity - 다음 버튼 클릭")
            Log.d(TAG, "before currentItem : ${my_intro_view_pager.currentItem}")
            my_intro_view_pager.currentItem = (my_intro_view_pager.currentItem + 1) % pageItemList.size
            Log.d(TAG, "after currentItem : ${my_intro_view_pager.currentItem}")

        }

        // 데이터 배열을 준비
        pageItemList.add(PageItem(R.color.colorOrange, R.drawable.ic_pager_item_1, R.drawable.ic_pager_item_2, "안녕하세요!\n 개발하는 오모지입니다~"))

        pageItemList.add(PageItem(R.color.colorBlue, R.drawable.ic_pager_item_3, R.drawable.ic_pager_item_4, "오늘도 빡코딩 하시나요?"))

        pageItemList.add(PageItem(R.color.colorWhite, R.drawable.ic_pager_item_5, R.drawable.ic_pager_item_6, "좋은하루 되세요~"))

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

    // 아래의 단점은 토스트 이후에 back버튼 눌러도 닫힘 ( 카운트 ) 딜레이시간을 고려안함
    /**
     * Back button listener.
     * Will close the application if the back button pressed twice.
     */
    /**
    var backButtonCount : Int = 0
    override fun onBackPressed() {

        Log.d(TAG, "MainActivity - back button : $backButtonCount")
        if (backButtonCount >= 1) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            backButtonCount = 0     // 한번 닫았으면 다시 초기화
            Log.d(TAG, "Close - back button : $backButtonCount")
        } else {
            Toast.makeText(this, "Press the back button once again to close the application.", Toast.LENGTH_SHORT).show()
            backButtonCount++
        }
    }
    */
    // 마지막으로 뒤로가기 버튼을 눌렀던 시간 저장
    private var backKeyPressedTime: Long = 0

    // 첫 번째 뒤로가기 버튼을 누를때 표시
    private lateinit var toast: Toast

    override fun onBackPressed() {
        // 기존 뒤로가기 버튼의 기능을 막기위해 주석처리 또는 삭제
        // super.onBackPressed();

        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지났으면 Toast Show
        // 2000 milliseconds = 2 seconds
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)
            toast.show()
            return
        }
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간에 2초를 더해 현재시간과 비교 후
        // 마지막으로 뒤로가기 버튼을 눌렀던 시간이 2초가 지나지 않았으면 종료
        // 현재 표시된 Toast 취소
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish()
            toast.cancel()
        }
    }
}