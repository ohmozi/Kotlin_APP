package com.example.customdialog_tutorial

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity(), CustomDialogInterface {       // implements -> 리스너를 설정한다

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDialogClicked(view: View){
        Log.d(TAG, "MainActivity - onDialogBtnClicked() called")

        val customDialog = CustomDialog(this, this)     // 생성자 쪽 확인

        customDialog.show()
    }

    // 구독 버튼 클릭
    override fun onSubscribeBtnClicked() {
        Log.d(TAG, "MainActivity - onSubscribeBtnClicked() called")
        Toast.makeText(this, "구독 버튼 클릭!", Toast.LENGTH_SHORT).show()
    }

    // 좋아요 버튼 클릭
    override fun onLikeBtnClicked() {
        Log.d(TAG, "MainActivity - onLikeBtnClicked() called")
        Toast.makeText(this, "좋아요 버튼 클릭!", Toast.LENGTH_SHORT).show()
    }
    // customdialog와 mainactivity는 다른 존재임
    // 그래서 customdialog에서 클릭됐을때 mainactivity가 감지할수있어야함 -> 인터페이스 사용할것
}