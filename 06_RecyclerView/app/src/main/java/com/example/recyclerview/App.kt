package com.example.recyclerview

import android.app.Application

class App : Application(){  // 뷰홀더 클래스는 컨텍스트를 상속받지않음(가지고있지않음), 따라서 현재 app이라는 클래스를 전역으로 선언해서 쓸수있게함
    // 전역으로 쓸수있게 하려면 Manifest에 name으로 선언해줘야한다.
    companion object{           // 싱글톤 강의 들어보기
        lateinit var instance: App// 나중에 값을 넣는다 ->
        private set     // 자기자신을 가져온다 , 썼던 애를 가져온다
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}