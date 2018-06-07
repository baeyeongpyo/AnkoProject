package com.example.yeongpyo.ankoproject

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.yeongpyo.ankoproject.anko_UI.recyclerItem
import com.example.yeongpyo.ankoproject.anko_UI.recyclerview_dataDB
import org.jetbrains.anko.*

class mainRecylerView_adapter(context: Context, val arr: ArrayList<recyclerview_dataDB>) : RecyclerView.Adapter<mainRecylerView_adapter.Holder>() {
    val ankocontext = AnkoContext.createReusable(context, this)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(recyclerItem().createView(ankocontext))
    override fun getItemCount(): Int = arr.size
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.let {
            it.textview1.text = arr[position].text1
            it.textview2.text = arr[position].text2
        }
    }

    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val textview1 = itemView!!.findViewById<TextView>(R.id.itemTextView1)
        val textview2 = itemView!!.findViewById<TextView>(R.id.itemTextView2)
    }

}