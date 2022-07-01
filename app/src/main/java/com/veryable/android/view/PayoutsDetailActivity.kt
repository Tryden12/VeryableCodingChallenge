package com.veryable.android.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.veryable.android.R
import com.veryable.android.databinding.ActivityPayoutsDetailBinding
import com.veryable.android.databinding.ActivityPayoutsListBinding
import com.veryable.android.utils.Constants

class PayoutsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPayoutsDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_payouts_detail)

        getIntentData()
    }

    private fun getIntentData() {
        val intent = intent
        val accountName = intent.getStringExtra("accountName").toString()
        val accountDesc = intent.getStringExtra("accountDesc").toString()
        binding.accountNameTextview.text = accountName
        binding.bankNameTextview.text = accountDesc
        Log.d("DEBUG_INTENT", "$accountName, $accountDesc")
    }
}