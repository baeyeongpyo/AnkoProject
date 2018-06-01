package com.example.yeongpyo.ankoproject.ConstraintSetTest

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.TextView
import com.example.yeongpyo.ankoproject.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout._ConstraintLayout
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.constraintSet
import org.jetbrains.anko.sdk25.coroutines.onClick

class ConstrainSetUImaker : AnkoComponent<ConstrainSetMain> {
    override fun createView(ui: AnkoContext<ConstrainSetMain>): ConstraintLayout =
            with(ui) {
                constraintLayout {
                    id = constrainSetMainLayoutID
                    textView1().lparams(wrapContent, wrapContent) {
                        constrainSetMainLayoutID.let {
                            leftToLeft = it
                            rightToRight = it
                            topToTop = it
                            bottomToBottom = it
                        }
                        verticalBias = 0.3F
                    }
                    Buttonview().lparams(matchParent, wrapContent) {
                        constrainSetMainLayoutID.let {
                            leftToLeft = it
                            rightToRight = it
                            bottomToBottom = it
                        }
                    }
                }
            }


    val constrainSetMainLayoutID = R.id.constrainSetMainlayout
    val ChangeText = R.id.ConstrainSetTextVeiw
    val ChangeButton = R.id.ConstrainButton

    private fun @AnkoViewDslMarker _ConstraintLayout.Buttonview(): Button =
            button("Change Button") {
                id = ChangeButton
            }

    private fun @AnkoViewDslMarker _ConstraintLayout.textView1(): TextView =
            textView("첫번째 페이지") {
                id = ChangeText
                textSize = dip(20).toFloat()
            }

    private fun @AnkoViewDslMarker _ConstraintLayout.textView2(): TextView =
            textView("두번째 페이지") {
                id = ChangeText
                textSize = dip(10).toFloat()
            }

}