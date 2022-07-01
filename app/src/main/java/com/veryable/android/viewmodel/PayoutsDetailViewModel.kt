package com.veryable.android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veryable.android.data.Account

class PayoutsDetailViewModel : ViewModel() {

    // Live data from the api
    var liveDataList: MutableLiveData<Account> = MutableLiveData()

    // Observer for live data
    fun getLiveDataObserver() : MutableLiveData<Account> {
        return liveDataList
    }

    // Set data for data
    fun setItemData(account : Account?) {
        liveDataList.value = account
    }

}