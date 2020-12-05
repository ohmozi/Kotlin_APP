package com.example.bottomnaviwithfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    // 멤버 변수 선언
    private lateinit var homeFragment: HomeFragment
    private lateinit var rankingFragment: RankingFragment
    private lateinit var profileFragment: ProfileFragment
//    private var profileFragment: ProfileFragment?= null // lateinit과 같은 표기

    companion object{

        const val TAG: String = "로그"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 레이아웃과 연결
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        bottom_navi.setOnNavigationItemSelectedListener(onButtomNavItemSelectedListener)

        // 최초 oncreate가 됐을때 홈으로 끼워주기
        homeFragment = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction().add(R.id.fragments_frame, homeFragment).commit()      // 처음엔 add로 들어가야 추가됨 (replace는 교체할때)
    }

    // 인터페이스 없이 바텀네비게이션 아이템 클릭 리스너를 따로 설정
    private val onButtomNavItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {

        when(it.itemId){
            R.id.menu_home -> {
                Log.d(TAG, "MainActivity - 홈 버튼 클릭!")
                homeFragment = HomeFragment.newInstance()  // 싱글톤했을때랑 똑같다고 생각하면됨
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, homeFragment).commit()       // homefragment 를 프레임에 넣어라 {replace와 add방법이있음}
            }
            R.id.menu_ranking -> {
                Log.d(TAG, "MainActivity - 랭킹 버튼 클릭!")
                rankingFragment = RankingFragment.newInstance()  // 싱글톤했을때랑 똑같다고 생각하면됨
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, rankingFragment).commit()
            }
            R.id.menu_profile -> {
                Log.d(TAG, "MainActivity - 프로필 버튼 클릭!")
                profileFragment = ProfileFragment.newInstance()  // 싱글톤했을때랑 똑같다고 생각하면됨
                supportFragmentManager.beginTransaction().replace(R.id.fragments_frame, profileFragment).commit()
            }
        }
        true        // 이건 뭐지?
    }

    // 메인에서 bottom naiv가 눌린것을 알아야함
    // interface 상속해서 사용하는 방법
//    override fun onNavigationItemSelected(item: MenuItem): Boolean {
//        Log.d(TAG, "MainActivity - onNavigationItemSelected() called")
//
//        when(item.itemId){
//            R.id.menu_home -> {
//                Log.d(TAG, "MainActivity - 홈 버튼 클릭!")
//            }
//            R.id.menu_ranking -> {
//                Log.d(TAG, "MainActivity - 랭킹 버튼 클릭!")
//            }
//            R.id.menu_profile -> {
//                Log.d(TAG, "MainActivity - 프로필 버튼 클릭!")
//            }
//        }
//        return true
//    }
}