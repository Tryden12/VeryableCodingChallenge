package com.veryable.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.veryable.android.R
import com.veryable.android.data.Account
import com.veryable.android.utils.Constants.BANK
import com.veryable.android.utils.Constants.CARD
import kotlinx.android.synthetic.main.list_item.view.*
import org.w3c.dom.Text

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    private var accountList: List<Account>? = null

    fun setAccountList(accountList: List<Account>?) {
        this.accountList = accountList
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(accountList?.get(position))

    }

    override fun getItemCount(): Int {
        return if (accountList == null) 0
        else accountList?.size!!
    }


    /************ Item View Holder Inner Class ******************/
    class ItemViewHolder(val view: View) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

        fun bind(data : Account?) {
            val itemTitle = view.item_title_textview
            val itemDesc = view.item_desc_textview
            val itemDeliveryDesc = view.item_desc_delivery_textview
            val accountImage = view.item_icon

            if (data != null) {
                itemTitle.text = data.accountName
                itemDesc.text = data.description
            }
            if (data != null) {
                if (data.accountType.equals(CARD)) {
                    accountImage.setImageResource(R.drawable.bank_icon_black)
                    itemDeliveryDesc.text = "Bank Account: ACH - Same Day"
                }
            }
/*
            when (data?.accountType ?: "") {
                BANK -> {
                    accountImage.setImageResource(R.drawable.bank_icon_black)
                    itemDeliveryDesc.text = "Bank Account: ACH - Same Day"
                }
                CARD -> {
                    accountImage.setImageResource(R.drawable.card_icon_black)
                    itemDeliveryDesc.text = "Card: Instant"
                }
            }

 */
        }


        init {
            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }

    }
}