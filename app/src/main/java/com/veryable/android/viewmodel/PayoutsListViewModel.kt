package com.veryable.android.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.veryable.android.data.Account
import com.veryable.android.retrofit.RetroInstance.apiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PayoutsListViewModel : ViewModel() {

    // Live data for the list from Api
    var liveDataList: MutableLiveData<MutableList<Account>> = MutableLiveData()

    // Live data for each item
    var liveItemData: MutableLiveData<Account> = MutableLiveData()

    // Observer for live list
    fun getLiveDataObserver(): MutableLiveData<MutableList<Account>> {
        return liveDataList
    }

    // Observer for each item
    fun getLiveItemObserver(): MutableLiveData<Account> {
        return liveItemData
    }

    // set the account info on click
    fun setAccountItemOnClick(account: Account?, position: Int) {
        liveItemData.value = account
    }


    // Api call for list data
    fun makeApiCall() {
        val call = apiService.getData()
        call.enqueue(object : Callback<MutableList<Account>> {
            override fun onResponse(
                call: Call<MutableList<Account>>,
                response: Response<MutableList<Account>>,
            ) {
                liveDataList.postValue(response.body())
            }

            override fun onFailure(call: Call<MutableList<Account>>, t: Throwable) {
                liveDataList.postValue(null)
            }

        })
    }
}