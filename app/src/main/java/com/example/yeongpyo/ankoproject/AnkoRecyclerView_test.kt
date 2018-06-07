package com.example.yeongpyo.ankoproject

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.yeongpyo.ankoproject.anko_UI.mainUI_Make
import com.example.yeongpyo.ankoproject.anko_UI.recyclerview_dataDB
import org.jetbrains.anko.linearLayout
import org.jetbrains.anko.setContentView

class AnkoRecyclerView_test : AppCompatActivity() {

    val UImake = mainUI_Make()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(UImake.setContentView(this))

    }


    override fun onResume() {
        super.onResume()
        val arraylist = ArrayList<recyclerview_dataDB>().apply {
            add( recyclerview_dataDB("test1", "첫번째 테스트"))
            add( recyclerview_dataDB("test2", "두번째 테스트"))
            add( recyclerview_dataDB("test3", "세번째 테스트"))
        }
        UImake.recyclerview.apply {
            adapter = mainRecylerView_adapter(this@AnkoRecyclerView_test, arraylist)
            layoutManager = LinearLayoutManager(this@AnkoRecyclerView_test).apply { orientation = LinearLayoutManager.VERTICAL }
        }

    }
}