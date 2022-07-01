package com.veryable.android.listeners

import com.veryable.android.data.Account
import java.text.FieldPosition

interface AccountClickListener {
    fun accountItemClick(account: Account?, position: Int)
}