package com.example.yeongpyo.ankoproject.anko_UI

import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.yeongpyo.ankoproject.AnkoRecyclerView_test
import com.example.yeongpyo.ankoproject.MainActivity
import com.example.yeongpyo.ankoproject.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView

class mainUI_Make : AnkoComponent<AnkoRecyclerView_test> {

    lateinit var recyclerview : RecyclerView

    override fun createView(ui: AnkoContext<AnkoRecyclerView_test>): View {
        val mainconstraint = R.id.mainConstraint
        val mainTextView = R.id.mainTextView
        val mainRecylerView = R.id.mainRecylerView
        return with(ui) {
            constraintLayout {
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

}