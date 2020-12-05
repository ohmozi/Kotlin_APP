package com.example.bottomnaviwithfragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment: Fragment() {

    // 파라미터가 있는 싱글톤
    companion object{
        const val TAG : String = "로그"

        // 홈 프레그먼트의 메모리에 올라간 애를 가져온다.
        fun newInstance() : HomeFragment{
            return HomeFragment()
        }
    }

    // 메모리에 올라갔을 때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment - onCreate() called")
    }

    // 종속되는 엑티비티에 프레그먼트가 붙을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment - onAttach() called")
    }

    // 메인엑티비티와 메인레이아웃을 연결해주는 것처럼 (setOnContentView처럼)
    // 프레그먼트와 레이아웃을 연결해준다
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.d(TAG, "HomeFragment - onCreateView() called")

        val view = inflater.inflate(R.layout.fragment_home, container, false) // adapter부분이랑 비슷한 패턴

        return view
    }
}