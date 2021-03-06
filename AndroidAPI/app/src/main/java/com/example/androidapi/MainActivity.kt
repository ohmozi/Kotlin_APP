package com.example.androidapi

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.androidapi.utils.Constants.TAG
import com.example.androidapi.utils.SEARCH_TYPE
import com.example.androidapi.utils.onMyTextChanged
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.layout_button_search.*

class MainActivity : AppCompatActivity() {

    private var currentSearchType: SEARCH_TYPE = SEARCH_TYPE.PHOTO

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "MainActivity - onCreate() called")

        // 라디오 그룹 가져오기
        radioGroup.setOnCheckedChangeListener { _, checkedId ->

            // switch 문
            when(checkedId){
                R.id.r_btn1 -> {
                    Log.d(TAG, "사진 검색버튼 클릭")
                    search_term_text_layout.hint = "사진 검색"
                    // newTheme 안해도되는데 함수가 deprecated됐다해서 추가함

                    search_term_text_layout.startIconDrawable = resources.getDrawable(R.drawable.ic_baseline_photo_library_24,resources.newTheme())
                    this.currentSearchType = SEARCH_TYPE.PHOTO
                }
                R.id.r_btn2 -> {
                    Log.d(TAG, "사용자 검색버튼 클릭")
                    search_term_text_layout.hint = "사용자 검색"
                    search_term_text_layout.startIconDrawable = resources.getDrawable(R.drawable.ic_baseline_person_24,resources.newTheme())
                    this.currentSearchType = SEARCH_TYPE.NAME
                }
            }
            Log.d(TAG, "MainActivity - OnCheckedChanged() called / currentSearchType : $currentSearchType")

        }

        // 텍스트가 변경이 되었을 때
        search_term_edit_text.onMyTextChanged {
            // 입력된 글자가 하나라도 있다면
            if(it.toString().count() > 0){
                // 검색 버튼을 보여준다.
                frame_search_btn.visibility = View.VISIBLE
                search_term_text_layout.helperText = " "

                // 스크롤 뷰를 올린다.
                main_scrollview.scrollTo(0,500)
            } else{
                frame_search_btn.visibility = View.INVISIBLE
            }

            if(it.toString().count() == 12){
                Log.d(TAG, "MainActivity - 에러 띄우기")
                Toast.makeText(this, "검색어는 12자까지만 입력가능합니다.", Toast.LENGTH_SHORT).show()
            }
        }

        // 버튼 클릭시
        btn_search.setOnClickListener{
            Log.d(TAG, "MainActivity - 검색 버튼 클릭됨 / currentSearchType : $currentSearchType")

            handleSearchButtonUi()
        }

    }   // onCreate

    private fun handleSearchButtonUi(){
        btn_progress.visibility = View.VISIBLE

        btn_search.text = ""

        Handler().postDelayed({
            btn_progress.visibility = View.INVISIBLE
            btn_search.text = "검색"
        }, 1500)
    }


    private var backKeyPressedTime: Long = 0
    private lateinit var toast: Toast

    override fun onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis()
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT)
            toast.show()
            return
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish()
            toast.cancel()
        }
    }
}