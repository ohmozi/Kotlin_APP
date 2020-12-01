package com.example.recyclerview

// 이벤트가 생겼을 때 인터페이스를 등록한 애들한테 알려주도록 한다.
// 커스텀 인터페이스 만드는 중임 (setOnClickListener 같은것이 인터페이스)
interface MyRecyclerviewInterface {
    fun onItemClicked(postion: Int)
}