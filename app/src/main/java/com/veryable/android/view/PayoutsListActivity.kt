package com.veryable.android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.veryable.android.R
import com.veryable.android.adapter.Adapter
import com.veryable.android.databinding.ActivityPayoutsListBinding
import com.veryable.android.utils.Constants.BANK
import com.veryable.android.viewmodel.PayoutsListViewModel
import kotlinx.android.synthetic.main.activity_payouts_detail.*

class PayoutsListActivity : AppCompatActivity() {

    private lateinit var binding : ActivityPayoutsListBinding
    private lateinit var bankAdapter: Adapter
    private lateinit var cardAdapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_list)

        initView()
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
        }
    }

    private fun initViewModel() {
        val viewModel: PayoutsListViewModel = PayoutsListViewModel()
        viewModel.getLiveDataObserver().observe(this@PayoutsListActivity, Observer {
            if (it != null) {
                bankAdapter.setAccountList(it.filter { it1 -> it1.accountType == BANK })
                bankAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Error retrieving data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeApiCall()
    }

    }

