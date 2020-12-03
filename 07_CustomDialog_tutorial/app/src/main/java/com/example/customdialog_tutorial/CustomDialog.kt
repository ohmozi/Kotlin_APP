package com.example.customdialog_tutorial

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.custom_dialog.*

class CustomDialog(context: Context, customDialogInterface: CustomDialogInterface)  // 생성자로 넣어서 상속받는 Dialog에 context를 넣어준다
    : Dialog(context)
{
    val TAG: String = "로그"

    //
    private var customDialogInterface: CustomDialogInterface? = null

    // 인터페이스 연결
    init {
        this.customDialogInterface = customDialogInterface
    }

    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.custom_dialog)

        Log.d(TAG, "CustomDialog - onCreate() called")
        // 배경 투명하게 설정
        window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))    // transparent : 투명하게

        // 좋아요 버튼이 클릭 되었을때
        like_btn.setOnClickListener{
            Log.d(TAG, "CustomDialog - 좋아요 버튼 클릭!")
            this.Cus// 메인에서 알수있도록 하기
        }
    }

}