package com.example.constructor_practive

import android.util.Log

// 클래스 이름
class MyFriend {
    val TAG: String = "로그"

    // 멤버 변수
    var name: String? = null
    var age: Int? = null
    var isMarried: Boolean? = null
    var nickname: String? = null

    // 기본 생성자
    init{
        Log.d(TAG, "MyFriend - init() is called")
        Log.d(TAG, "MainActivity - myFriend.name : ${name}")
        Log.d(TAG, "MainActivity - myFriend.age : ${age}")
        Log.d(TAG, "MainActivity - myFriend.isMarried : ${isMarried}")
        Log.d(TAG, "MainActivity - myFriend.nickname : ${nickname}")
    }
}