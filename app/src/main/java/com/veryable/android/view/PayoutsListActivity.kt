package com.veryable.android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.veryable.android.R
import com.veryable.android.adapter.Adapter
import com.veryable.android.databinding.ActivityPayoutsListBinding

class PayoutsListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPayoutsListBinding
    private lateinit var bankAdapter: Adapter
    private lateinit var cardAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_list)
    }

    private fun initRecyclerView(){
        binding.bankListRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PayoutsListActivity)
            bankAdapter = Adapter()
            adapter = bankAdapter
        }
    }
}