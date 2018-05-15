package com.example.yeongpyo.ankoproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Layout
import com.example.yeongpyo.ankoproject.anko_UI.mainUI_Make
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.textView
import org.jetbrains.anko.wrapContent

class MainActivity : AppCompatActivity() {

    lateinit var recyclerview : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view = mainUI_Make(this).UIMake()
        setContentView(view)
//            UIMake()

//        recyclerview.layoutManager = LinearLayoutManager(this)
//        recyclerview.adapter
    }

    fun UIMake(){
        val mainconstraint = R.id.mainConstraint
        val mainTextView = R.id.mainTextView
        val mainRecylerView = R.id.mainRecylerView
        constraintLayout {
            id = R.id.mainConstraint
            textView(" Anko!! Hello!! "){id = R.id.mainTextView}.lparams( wrapContent, wrapContent ){
                mainconstraint.let {
                    startToStart = it
                    endToEnd = it
                    topToTop = it
                    bottomToBottom = it
                }
            }
            recyclerview = recyclerView {
                id = R.id.mainRecylerView
            }.lparams( matchParent, wrapContent){
                mainconstraint.let {
                    startToStart = it
                    endToEnd = it
                    bottomToBottom = it
                }
                topToBottom = mainTextView
                topMargin = dip(15)
                marginEnd = dip(8)
                marginStart = dip(8)
                bottomMargin = dip(8)
            }
        }
    }
}
