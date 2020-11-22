package com.example.lottieanimationtutorial

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = "로그"

    var isLiked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        isLiked = false

        // 좋아요 버튼에 클릭 리스너를 달아준다.
        like_btn.setOnClickListener {
            if(isLiked == false){
                // 애니메이션의 커스텀
                // Custom animation speed or duration.
                // ofFloat(시작지점, 종료지점).setDuration(지속시간)
                val animator = ValueAnimator.ofFloat(0f, 0.7f).setDuration(1000)
                animator.addUpdateListener {
                    like_btn.setProgress(
                        animator.getAnimatedValue() as Float
                    )
                }
                animator.start()
                isLiked = true
            } else{ // 좋아요 상태일 때
                val animator = ValueAnimator.ofFloat(0.7f, 1f).setDuration(300)
                animator.addUpdateListener {
                    like_btn.setProgress(
                        animator.getAnimatedValue() as Float
                    )
                }
                animator.start()
                isLiked = false
            }
            Log.d(TAG, "MainActivity - onCreate() / 좋아요 버튼이 클릭되었습니다. isliked: ${isLiked}")
        }

    }
}