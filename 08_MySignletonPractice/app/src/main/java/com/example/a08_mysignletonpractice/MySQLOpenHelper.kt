package com.example.a08_mysignletonpractice

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MySQLOpenHelper(context: Context): SQLiteOpenHelper(context, "MyDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }
}