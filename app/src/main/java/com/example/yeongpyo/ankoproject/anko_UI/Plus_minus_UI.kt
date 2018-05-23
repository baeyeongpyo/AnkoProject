package com.example.yeongpyo.ankoproject.anko_UI

import android.view.View
import android.widget.TextView
import com.example.yeongpyo.ankoproject.MainActivity
import com.example.yeongpyo.ankoproject.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.sdk25.coroutines.onClick

class Plus_minus_UI : AnkoComponent<MainActivity> {

    val Plus_minus_UI_layout_ID = R.id.Plus_minus_UI
    val Plus_button_ID = R.id.Plus_button
    val Minus_button_ID = R.id.Minus_button
    lateinit var textview_view: TextView
    var Count = 0

    override fun createView(ui: AnkoContext<MainActivity>): View = with(ui) {
        constraintLayout {
            id = Plus_minus_UI_layout_ID
            lparams(matchParent, matchParent)

            textview_view = textView(Count.toString()) { textSize = dip(24).toFloat() }.lparams(wrapContent, wrapContent) {
                Plus_minus_UI_layout_ID.let {
                    leftToLeft = it
                    rightToRight = it
                    topToTop = it
                    bottomToBottom = it
                    verticalBias = 0.3F
                }
            }

           button("Minus") {
                id = Minus_button_ID
                onClick {
                    if (Count > 0) {
                        Count -= 1
                        textview_view.text = Count.toString()
                    }
                }
            }.lparams(dip(0), wrapContent) {
                leftToLeft = Plus_minus_UI_layout_ID
                bottomToBottom = Plus_minus_UI_layout_ID
                rightToLeft = Plus_button_ID
            }

            button("Plus") {
                id = Plus_button_ID
                onClick {
                    Count += 1
                    textview_view.text = Count.toString()
                }
            }.lparams(dip(0), wrapContent) {
                rightToRight = Plus_minus_UI_layout_ID
                bottomToBottom = Plus_minus_UI_layout_ID
                leftToRight = Minus_button_ID
            }

        }
    }

}