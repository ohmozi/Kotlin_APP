package com.example.layoutpractice


//****컨텍스트에 대한 공부 필요!!!****
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_01.*

// 메인화면
class Main01 : AppCompatActivity() {

    val TAG: String = "로그"
    // 뷰가 생성되었을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 그릴 xml 뷰 파일을 연결시켜준다. 즉, 설정한다
        setContentView(R.layout.activity_01)


        // 로그인 버튼 뷰에 클릭 리스너를 설정하였다.
//        login_btn.setOnClickListener(View.OnClickListener {
//
//            onLoginButtonClicked()
//
//        })
        // 람다식
        login_btn.setOnClickListener {
            onLoginButtonClicked()
        }
    }
    override fun onStart() {
        super.onStart()
        text_view.setText("Life Cycle")
        Log.d(TAG, "MainActivity - onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "MainActivity - onResume() called")
    }

    override fun onPause() {
        super.onPause()
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

    fun onLoginButtonClicked(){
        Log.d(TAG, "MainActivity - onLoginButtonClicked() called")

        val intent = Intent(this, Main02::class.java)

        startActivity(intent)
    }
}