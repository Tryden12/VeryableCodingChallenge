package com.veryable.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.veryable.android.R
import com.veryable.android.data.Account

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    private var list: List<Account>? = null

    fun setList(list: List<Account>?) {
        this.list = list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false) as TextView
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }


    /************ Item View Holder Inner Class ******************/
    inner class ItemViewHolder(val view: TextView) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

        fun bind(account : Account?) {

        }

    }
}