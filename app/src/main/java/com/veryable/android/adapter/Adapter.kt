package com.veryable.android.adapter

import android.app.Instrumentation
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.veryable.android.R
import com.veryable.android.data.Account
import com.veryable.android.utils.Constants.BANK
import com.veryable.android.utils.Constants.CARD
import com.veryable.android.view.PayoutsDetailActivity
import kotlinx.android.synthetic.main.list_item.view.*
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    private var accountList: List<Account>? = null

    fun setAccountList(accountList: List<Account>?) {
        this.accountList = accountList
    }

    fun getAccountList(): List<Account>? {
        return accountList
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
    inner class ItemViewHolder(val view: View) :
        RecyclerView.ViewHolder(view),
        View.OnClickListener {

        // Create variables for items in list_item layout
        private val itemTitle: TextView = view.findViewById(R.id.item_title_textview)
        private val itemDesc: TextView = view.findViewById(R.id.item_desc_textview)
        private val itemDeliveryDesc: TextView = view.findViewById(R.id.item_desc_delivery_textview)
        private val accountImage: ImageView = view.findViewById(R.id.item_icon)

        // Bind data to the variables
        fun bind(data : Account?) {

            if (data != null) {
                itemTitle.text = data.accountName
                itemDesc.text = data.description

                if (data.accountType == BANK) {
                    accountImage.setImageResource(R.drawable.bank_icon_black)
                    itemDeliveryDesc.text = "Bank Account: ACH - Same Day"
                } else {
                    accountImage.setImageResource(R.drawable.card_icon_black)
                    itemDeliveryDesc.text = "Card: Instant"
                }
            }

            Log.d("DEBUG_ACCOUNT", "$itemTitle, $itemDesc")

        }

        init {
            view.findViewById<View>(R.id.item_linear_layout).setOnClickListener(this)
        }

        override fun onClick(view: View?) {
            if (view != null) {
                val intent = Intent(view.context, PayoutsDetailActivity::class.java)
                view.context.startActivity(intent)

                val account = Adapter().getAccountList()?.get(adapterPosition)
            }
        }


    }
}