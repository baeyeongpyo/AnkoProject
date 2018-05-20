package com.example.yeongpyo.ankoproject

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.yeongpyo.ankoproject.R.id.textView
import com.example.yeongpyo.ankoproject.anko_UI.recyclerItem
import com.example.yeongpyo.ankoproject.anko_UI.recyclerview_dataDB
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.constraintLayout

class mainRecylerView_adapter(val arr : ArrayList<recyclerview_dataDB>) : RecyclerView.Adapter<mainRecylerView_adapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(recyclerItem(parent.context).textItem())

    override fun getItemCount(): Int = arr.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.let {
            it.textview1.text = arr[position].text1
            it.textview2.text = arr[position].text2
        }
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val textview1 = itemView!!.find<TextView>(R.id.itemTextView1)
        val textview2 = itemView!!.find<TextView>(R.id.itemTextView2)
    }

}