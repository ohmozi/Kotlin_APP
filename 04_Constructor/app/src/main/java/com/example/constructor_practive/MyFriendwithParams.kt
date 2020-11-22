package com.example.constructor_practive

import android.util.Log

class MyFriendwithParams(var name:String?, var age:Int?, var isMarried:Boolean?, var nickname:String?) {
    val TAG: String = "로그"

    // 기본 생성자
    init{
        Log.d(TAG, "MyFriendwithParams - init() is called")
        Log.d(TAG, "MainActivity - myFriendwithParams.name : ${name}")
        Log.d(TAG, "MainActivity - myFriendwithParams.age : ${age}")
        Log.d(TAG, "MainActivity - myFriendwithParams.isMarried : ${isMarried}")
        Log.d(TAG, "MainActivity - myFriendwithParams.nickname : ${nickname}")
    }
}