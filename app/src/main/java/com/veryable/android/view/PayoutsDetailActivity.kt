package com.veryable.android.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.veryable.android.R
import com.veryable.android.databinding.ActivityPayoutsDetailBinding
import com.veryable.android.databinding.ActivityPayoutsListBinding
import com.veryable.android.utils.Constants

class PayoutsDetailActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var binding: ActivityPayoutsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_detail)

        initView()
        getIntentData()
        binding.doneButton.setOnClickListener(this)
    }

    // Retrieve intent from account item clicked in previous activity
    private fun getIntentData() {
        val intent = intent
        val accountName = intent.getStringExtra("accountName").toString()
        val accountDesc = intent.getStringExtra("accountDesc").toString()
        val accountType = intent.getStringExtra("accountType").toString()
        binding.accountNameTextview.text = accountName
        binding.bankNameTextview.text = accountDesc
        if (accountType == Constants.CARD) {
            binding.bankIcon.setImageResource(R.drawable.card_icon_black)
        } else {
            binding.bankIcon.setImageResource(R.drawable.bank_icon_black)
        }
        Log.d("DEBUG_INTENT", "$accountName, $accountDesc")
    }

    // Setup toolbar with back button clickable
    private fun initView() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        binding.toolbar.setNavigationOnClickListener {
            onBackPressed()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    // Go back when done button pressed
    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.done_button -> {
                onBackPressed()
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
            }
        }
    }
}