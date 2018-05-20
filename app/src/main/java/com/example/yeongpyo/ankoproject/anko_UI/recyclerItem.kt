package com.example.yeongpyo.ankoproject.anko_UI

import android.content.Context
import android.widget.TextView
import com.example.yeongpyo.ankoproject.R
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.dip
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.textView

class recyclerItem(val context : Context) {
    val recyclerItem = R.id.recycleritem
    val item_textView1_ID = R.id.itemTextView1
    val item_textView2_ID = R.id.itemTextView2
    lateinit var item_textview1 : TextView
    lateinit var item_textview2 : TextView
    fun textItem() =
            context.constraintLayout{
                lparams( dip(matchParent), dip(400))
                id = recyclerItem
                item_textview1 = textView{ id = item_textView1_ID}.lparams(width = dip(60), height = dip(30)){
                    recyclerItem.let {
                        startToStart = it
                        endToEnd = it
                        topToTop = it
                        bottomToTop = item_textView2_ID
                    }
                }
                item_textview2 = textView{ id = item_textView2_ID }.lparams(dip(60), dip(30) ){
                    recyclerItem.let {
                        startToStart = it
                        endToEnd = it
                        topToBottom = item_textView1_ID
                        endToEnd = it
                    }
                }
            }

}