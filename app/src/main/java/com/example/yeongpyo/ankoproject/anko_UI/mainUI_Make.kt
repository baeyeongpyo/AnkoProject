package com.example.yeongpyo.ankoproject.anko_UI

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.yeongpyo.ankoproject.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class mainUI_Make (val context : Context)  {


    lateinit var recyclerview : RecyclerView

    fun UIMake(): View {
        val mainconstraint = R.id.mainConstraint
        val mainTextView = R.id.mainTextView
        val mainRecylerView = R.id.mainRecylerView
        return context.constraintLayout {
            id = mainconstraint
            textView(" Anko!! Hello!! ") { id = mainTextView }.lparams(wrapContent, wrapContent) {
                mainconstraint.let {
                    startToStart = it
                    endToEnd = it
                    topToTop = it
                    bottomToBottom = it
                }
            }
            recyclerview = recyclerView {
                id = mainRecylerView
            }.lparams(matchParent, wrapContent) {
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