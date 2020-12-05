package com.example.a08_mysignletonpractice

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLOpenHelperSingleton private constructor(context: Context): SQLiteOpenHelper(context, "MyDB", null, 1) {

    val TAG: String = "로그"

    companion object{
        // 클래스 안에있는 애들을 지정할때 companion사용
        // 싱글톤 구조를 볼때 자기 자신의 인스턴스를 선언하게 되어있음

        // 자기 자신 변수선언
        @Volatile private var instance: MySQLOpenHelperSingleton? = null      // CPU의 캐시를 거치지 않고 바로 메인메모리로가서 최신값을 유지할 수 있음

        // 자기 자신 가져오기
        fun getInstance(context: Context): MySQLOpenHelperSingleton =
            instance ?: synchronized(this){         // 반환 한 값이 비어있다면 자기 자신을 지칭
                instance ?: MySQLOpenHelperSingleton(context).also{ // also : 블락을 위함이라는데 뭐지
                    instance = it
                }
            }

    }

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}