package com.example.androidapi.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText


// edit text에 대한 extension
fun EditText.onMyTextChanged(compleetion: (Editable?) -> Unit){     // 코틀린의 컴플레션 블럭
    this.addTextChangedListener(object :TextWatcher{
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

        override fun afterTextChanged(editable: Editable) {
            compleetion(editable)
        }
    })
}