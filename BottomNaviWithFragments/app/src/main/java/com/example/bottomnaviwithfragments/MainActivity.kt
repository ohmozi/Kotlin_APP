package com.example.bottomnaviwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    // 멤버 변수 선언
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private var profileFragment: ProfileFragment?= null // lateinit과 같은 표기

    companion object{

        const val TAG: String = "로그"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 레이아웃과 연결
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        bottom_navi.setOnNavigationItemSelectedListener(this)
    }

    

    // 메인에서 bottom naiv가 눌린것을 알아야함
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "MainActivity - onNavigationItemSelected() called")

        when(item.itemId){
            R.id.menu_home -> {
                Log.d(TAG, "MainActivity - 홈 버튼 클릭!")
            }
            R.id.menu_ranking -> {
                Log.d(TAG, "MainActivity - 랭킹 버튼 클릭!")
            }
            R.id.menu_profile -> {
                Log.d(TAG, "MainActivity - 프로필 버튼 클릭!")
            }
        }
        return true
    }
}