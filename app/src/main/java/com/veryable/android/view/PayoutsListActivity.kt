package com.veryable.android.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.veryable.android.R
import com.veryable.android.adapter.Adapter
import com.veryable.android.databinding.ActivityPayoutsListBinding
import com.veryable.android.utils.Constants.BANK
import com.veryable.android.utils.Constants.CARD
import com.veryable.android.utils.Constants.ITEM_DATA
import com.veryable.android.viewmodel.PayoutsListViewModel

class PayoutsListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPayoutsListBinding
    private lateinit var bankAdapter: Adapter
    private lateinit var cardAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_list)

        initRecyclerView()
        initViewModel()
    }

    private fun initView() {
        setSupportActionBar(binding.toolbar)
    }

    private fun initRecyclerView(){
        binding.bankListRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PayoutsListActivity)
            bankAdapter = Adapter()
            adapter = bankAdapter

            // Add divider
            val divider = DividerItemDecoration(
                applicationContext, (layoutManager as LinearLayoutManager).orientation
            )
            addItemDecoration(divider)
        }

        binding.cardListRecyclerview.apply {
            layoutManager = LinearLayoutManager(this@PayoutsListActivity)
            cardAdapter = Adapter()
            adapter = cardAdapter

            // Add divider
            val divider = DividerItemDecoration(
                applicationContext, (layoutManager as LinearLayoutManager).orientation
            )
            addItemDecoration(divider)
        }
    }

    private fun initViewModel() {
        val viewModel: PayoutsListViewModel = ViewModelProvider(this).get(PayoutsListViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this@PayoutsListActivity, Observer {
            if (it != null) {
                //bankAdapter.setAccountList(it)
                bankAdapter.setAccountList(it.filter { it1 -> it1.accountType == BANK })
                bankAdapter.notifyDataSetChanged()
                //cardAdapter.setAccountList(it)
                cardAdapter.setAccountList(it.filter { it1 -> it1.accountType == CARD })
                cardAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error retrieving data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    }

