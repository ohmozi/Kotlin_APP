package com.example.layoutpractice

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_02.*

class Main02 : AppCompatActivity() {
    
    val TAG: String = "로그"

    var number: Int = 0
    var isLiked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_02)

        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        MobileAds.initialize(this) {}

        val adRequest = AdRequest.Builder().build()
        // 광고를 로드한다.
        banner.loadAd(adRequest)

        banner.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d(TAG, "SecondActivity - onAdLoaded() called")
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.d(TAG, "SecondActivity - onAdFailedToLoad() called")
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                Log.d(TAG, "SecondActivity - onAdOpened() called")
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.d(TAG, "SecondActivity - onAdClicked() called")
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d(TAG, "SecondActivity - onAdLeftApplication() called")
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.d(TAG, "SecondActivity - onAdClosed() called")
            }
        }

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

        add_number_btn.setOnClickListener {
            number++
            Log.d(TAG, "SecondActivity - add_number_btn 클릭 / number : ${number}")
            number_text.text = number.toString()
        }
        next_sensor_btn.setOnClickListener{
            onNextSensorButtonClicked()
        }
    }
    fun onNextSensorButtonClicked(){
        Log.d(TAG, "Main02 - onNextSensorButtonClicked() called")

        val intent = Intent(this, Main03::class.java)

        startActivity(intent)
    }
}