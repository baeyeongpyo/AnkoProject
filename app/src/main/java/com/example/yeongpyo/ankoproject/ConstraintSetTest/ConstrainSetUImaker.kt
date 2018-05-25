package com.example.yeongpyo.ankoproject.ConstraintSetTest

import android.annotation.SuppressLint
import android.content.Context
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.TextView
import com.example.yeongpyo.ankoproject.R
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout._ConstraintLayout
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.constraint.layout.constraintSet
import org.jetbrains.anko.sdk25.coroutines.onClick

class ConstrainSetUImaker(val context: Context) {

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

    fun Constrain_layout1(): ConstraintLayout =
            with(context) {
                constraintLayout {
                    onClick {
                        val bounds =  ChangeBounds().apply { interpolator = OvershootInterpolator() }
                        val test = ConstraintSet().apply { clone(Constrain_layout2())}
                        TransitionManager.beginDelayedTransition(this@constraintLayout, bounds)
                        test.applyTo(this@constraintLayout)
                        (this@ConstrainSetUImaker.context as ConstrainSetMain).setContentView(this@ConstrainSetUImaker.Constrain_layout2())
                    }
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
            }.apply {  }

    fun Constrain_layout2(): ConstraintLayout =
            with(context) {
                constraintLayout {
                    onClick {
                        val bounds =  ChangeBounds().apply { interpolator = OvershootInterpolator() }
                        val test = ConstraintSet().apply { clone(Constrain_layout1())}
                        TransitionManager.beginDelayedTransition(this@constraintLayout, bounds)
                        test.applyTo(this@constraintLayout)
                        (this@ConstrainSetUImaker.context as ConstrainSetMain).setContentView(this@ConstrainSetUImaker.Constrain_layout1())
                    }
                    id = constrainSetMainLayoutID
                    textView2().lparams(wrapContent, wrapContent) {
                        constrainSetMainLayoutID.let {
                            leftToLeft = it
                            rightToRight = it
                            topToTop = it
                            bottomToBottom = it
                        }
                        verticalBias = 0.1F
                    }
                    Buttonview().lparams(matchParent, wrapContent) {
                        constrainSetMainLayoutID.let {
                            leftToLeft = it
                            rightToRight = it
                            bottomToBottom = it
                            topToTop = it
                        }
                    }.apply { onClick { toast("aa") } }
                }
            }.apply { bringToFront() }

    var constrainsetBoolean = false
    fun Bounds(){
        var constrainset1 = Constrain_layout1()
        var constrainset2 = Constrain_layout2()

        val setitem1 = ConstraintSet().apply { clone(constrainset1) }
        val setitem2 = ConstraintSet().apply { clone(constrainset2) }

        val bounds = ChangeBounds().apply { interpolator = OvershootInterpolator() }
        TransitionManager.beginDelayedTransition(constrainset1, bounds)
        val constraint = if ( constrainsetBoolean ) setitem1 else setitem2
        constraint.applyTo(constrainset1)
        constrainsetBoolean = !constrainsetBoolean
    }

}