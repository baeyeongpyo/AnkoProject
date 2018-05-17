package com.example.yeongpyo.ankoproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.yeongpyo.ankoproject.anko_UI.AnkoUIMaker

class AnkoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(AnkoUIMaker(this).UiMake())
    }
}
