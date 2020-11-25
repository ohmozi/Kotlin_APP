package com.example.recyclerview

import android.util.Log

// 코틀린은 데이터만 다룰때는 data라는 클래스명 사용함
class MyModel(var name: String? = null, var profileImage: String? = null, var number: String? = null) {
    val TAG: String = "로그"

    // 기본 생성자
    init {
        Log.d(TAG, "MyModel - () called")
    }
}