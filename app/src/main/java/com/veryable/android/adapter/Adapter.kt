package com.veryable.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.veryable.android.R
import com.veryable.android.data.Account
import kotlinx.android.synthetic.main.list_item.view.*

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    private var accountList: List<Account>? = null

    fun setAccountList(accountList: List<Account>?) {
        this.accountList = accountList
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Adapter.ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        if (accountList == null) return 0
        else return accountList?.size!!
    }


    /************ Item View Holder Inner Class ******************/
    inner class ItemViewHolder(val view: View) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

        val accountImage: ImageView    = view.item_icon
        val itemTitle: TextView        = view.item_title_textview
        val itemDesc: TextView         = view.item_desc_textview
        val itemDescDelivery: TextView = view.item_desc_delivery_textview

        fun bind(data : Account?) {
            if (data != null) {
                itemTitle.text = data.accountName ?: ""
                itemDesc.text = data.description ?: ""
            }
        }


        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }
}