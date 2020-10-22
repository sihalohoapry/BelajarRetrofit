package com.sihaloho.belajarretrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class DrafHistoryAdapter (private val list: ArrayList<DraftHistoryResponse>)
    : RecyclerView.Adapter<DrafHistoryAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        fun onBindData(draftHistoryResponse: DraftHistoryResponse){
            with(itemView){
                val text = "PointCap :${draftHistoryResponse.id}\n" +
                        "West Player No 1 : ${draftHistoryResponse.title}\n" +
                        "West Player No 2 : ${draftHistoryResponse.body}\n"

                tv_text.text = text
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBindData(list[position])
    }

}



