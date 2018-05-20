package com.example.yeongpyo.ankoproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import com.example.yeongpyo.ankoproject.anko_UI.mainUI_Make
import com.example.yeongpyo.ankoproject.anko_UI.recyclerview_dataDB
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.textView
import org.jetbrains.anko.wrapContent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ViewMaker = mainUI_Make(this)
        setContentView(ViewMaker.UIMake())

        val arraylist = ArrayList<recyclerview_dataDB>().apply {
            add( recyclerview_dataDB("test1", "첫번째 테스트"))
            add( recyclerview_dataDB("test2", "두번째 테스트"))
            add( recyclerview_dataDB("test3", "세번째 테스트"))
        }

        ViewMaker.recyclerview.apply {
            adapter = mainRecylerView_adapter(context, arraylist)
            layoutManager = LinearLayoutManager(context)
        }
    }

}
