package com.example.yeongpyo.ankoproject.anko_UI

import android.content.Context
import android.view.View
import android.widget.TextView
import com.example.yeongpyo.ankoproject.R
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.textView
import org.jetbrains.anko.wrapContent

class AnkoUIMaker(val context: Context) {
    private val constraintlayoutID = R.id.ankoConstraintLayout
    // 추가
    lateinit var textview : TextView
    fun UiMake(): View =
            context.constraintLayout {
                id = constraintlayoutID
                // 추가
                textview = textView("Anko Hello").lparams(wrapContent, wrapContent) {
                    startToStart = constraintlayoutID
                    endToEnd = constraintlayoutID
                    topToTop = constraintlayoutID
                    bottomToBottom = constraintlayoutID
                }
            }
}