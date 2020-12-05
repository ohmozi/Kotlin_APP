package com.example.a08_mysignletonpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

// 코틀린 싱글톤 및 매개변수를 사용한 싱글톤 
class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 메모리를 객체가 생성될때 다르게 쓴다
        val myNormalClass_1 = MyNormalClass()
        val myNormalClass_2 = MyNormalClass()
        Log.d(TAG, "MainActivity - myNormalClass_1 : $myNormalClass_1")
        Log.d(TAG, "MainActivity - myNormalClass_2 : $myNormalClass_2")

        // 객체가 생성될때 메모리를 함께 쓴다
        val mySingletonClass_1 = MySingletonClass
        val mySingletonClass_2 = MySingletonClass
        Log.d(TAG, "MainActivity - mySingletonClass_1 : $mySingletonClass_1")
        Log.d(TAG, "MainActivity - mySingletonClass_2 : $mySingletonClass_2")
        // 생성자가 안들어가는 일반 싱글톤은 object로 만들면됨

        // 생성자가 들어가는 싱글톤은 문제가 있음 (MySQLOpenHelper 참고)
        val mySQLOpenHelper_1 = MySQLOpenHelper(this)
        val mySQLOpenHelper_2 = MySQLOpenHelper(this)
        Log.d(TAG, "MainActivity - mySQLOpenHelper_1 : $mySQLOpenHelper_1")
        Log.d(TAG, "MainActivity - mySQLOpenHelper_2 : $mySQLOpenHelper_2")
        // 로컬 디비 사용할때 매번 호출할때마다 다른애를 쓰게되면 메모리 낭비가 있으니 싱글톤을 사용한다.


        // 생성자가 들어가는 싱글톤을 해결하기 위함 (MySQLOpenHelperSingleton 참고)
        val mySQLOpenHelperSingleton_1 = MySQLOpenHelperSingleton.getInstance(this)
        val mySQLOpenHelperSingleton_2 = MySQLOpenHelperSingleton.getInstance(this)
        Log.d(TAG, "MainActivity - mySQLOpenHelperSingleton_1 : $mySQLOpenHelperSingleton_1")
        Log.d(TAG, "MainActivity - mySQLOpenHelperSingleton_2 : $mySQLOpenHelperSingleton_2")

    }






}