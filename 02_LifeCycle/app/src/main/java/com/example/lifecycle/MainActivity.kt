package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
/*
build.gradel(app)에 추가하기
plugins {
    id 'com.android.application'
    id 'kotlin-android'
    id 'kotlin-android-extensions'  // 중요 KTX(kotlin android extension)
}
*/

class MainActivity : AppCompatActivity() {
    val TAG: String = "로그"
    // 액티비티가 생성되었을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //레이아웃을 설정
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "MainActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
        text_view.visibility = View.VISIBLE
        text_view.setText("onPause()")
        Log.d(TAG, "MainActivity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "MainActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "MainActivity - onDestroy() called")
    }
}