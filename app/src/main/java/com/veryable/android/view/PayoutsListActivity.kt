package com.veryable.android.view

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

    // Setup RecyclerViews
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

    // Setup viewModel
    private fun initViewModel() {
        val viewModel: PayoutsListViewModel = ViewModelProvider(this).get(PayoutsListViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this@PayoutsListActivity, Observer {

            // Set account lists and filter between adapters
            if (it != null) {
                bankAdapter.setAccountList(it.filter { account -> account.accountType == BANK })
                bankAdapter.notifyDataSetChanged()
                cardAdapter.setAccountList(it.filter { account -> account.accountType == CARD })
                cardAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error retrieving data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    }

