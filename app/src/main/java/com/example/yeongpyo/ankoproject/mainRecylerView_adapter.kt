package com.example.yeongpyo.ankoproject

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.yeongpyo.ankoproject.R.id.textView
import com.example.yeongpyo.ankoproject.anko_UI.recyclerview_dataDB
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class mainRecylerView_adapter(val context : Context,val arr : ArrayList<recyclerview_dataDB>) : RecyclerView.Adapter<mainRecylerView_adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(recyclerItem(parent.context))

    override fun getItemCount(): Int = arr.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.let {
            it.textview1.text = arr[position].text1
            it.textview2.text = arr[position].text2
        }
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val textview1 = itemView!!.find<TextView>(item_textView1_ID)
        val textview2 = itemView!!.find<TextView>(item_textView2_ID)
    }

    fun mainitemView() {
    }

    val recyclerItem = R.id.recycleritem
    val item_textView1_ID = R.id.itemTextView1
    val item_textView2_ID = R.id.itemTextView2
    lateinit var item_textview1 : TextView
    lateinit var item_textview2 : TextView
    fun recyclerItem(context : Context) =
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