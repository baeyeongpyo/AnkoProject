package com.example.yeongpyo.ankoproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.textView
import org.jetbrains.anko.wrapContent

class Frist : AppCompatActivity() {
    val mainconstraint = R.id.mainConstraint
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        constraintLayout {
            id = R.id.mainConstraint
            textView(" Anko!! Hello!! ").lparams( wrapContent, wrapContent ){
                mainconstraint.let {
                    startToStart = it
                    endToEnd = it
                    topToTop = it
                    bottomToBottom = it
                }
            }
        }
    }
}
