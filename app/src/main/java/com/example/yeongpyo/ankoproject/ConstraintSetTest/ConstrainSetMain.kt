package com.example.yeongpyo.ankoproject.ConstraintSetTest

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.animation.OvershootInterpolator
import android.widget.Button
import com.example.yeongpyo.ankoproject.R
import kotlinx.android.synthetic.main.activity_ani.*
import org.jetbrains.anko.find

class ConstrainSetMain : AppCompatActivity() {
    var constrainsetBoolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val customclone = constraintsetclass_custom()
        val test1 = LayoutInflater.from(this).inflate(R.layout.activity_ani, null) as ConstraintLayout
        val test2 = LayoutInflater.from(this).inflate(R.layout.activity_ani, null) as ConstraintLayout
        setContentView(test1)

        val aniset1 = customclone.apply { clone(this@ConstrainSetMain, R.layout.activity_ani) }
        val aniset2 = customclone.apply { clone(this@ConstrainSetMain, R.layout.activity_ani2) }
        var Change = false
        anibutton.setOnClickListener {
            val bounds = ChangeBounds().apply { interpolator = OvershootInterpolator() }
            TransitionManager.beginDelayedTransition(test1, bounds )
            val constraint = if ( Change) aniset1 else  aniset2
            constraint.applyTo(test1)
            Change = !Change
        }

       /* val ConstraintUIMaker = ConstrainSetUImaker(this)
        setContentView(ConstraintUIMaker.Constrain_layout1())
        var constrainset1 = ConstraintUIMaker.Constrain_layout1()
        var constrainset2 = ConstraintUIMaker.Constrain_layout2()

        var setitem1 = ConstraintSet().apply { clone(constrainset1) }
        var setitem2 = ConstraintSet().apply { clone(this@ConstrainSetMain , R.layout.test) }
*/
        /*constrainset1.find<Button>(ConstraintUIMaker.ChangeButton).setOnClickListener {
            val bounds = ChangeBounds().apply { interpolator = OvershootInterpolator() }
            TransitionManager.beginDelayedTransition(constrainset1, bounds)
            val constraint: ConstraintSet = if ( constrainsetBoolean ) setitem1 else setitem2
            constraint.applyTo(constrainset1)
            constrainsetBoolean = !constrainsetBoolean
        }*/
    }
}