package com.example.constructor_practive

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        var myFriend = MyFriend()

        var myFriendwithParams = MyFriendwithParams("지훈",26,false,"ohmozi")

        var myFriendlala = MyFriendwithParams(null,null,null,"")


    }
}