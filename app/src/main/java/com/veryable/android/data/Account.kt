package com.veryable.android.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Account (
    val id : String? = null,
    val account_type : String? = null,
    val account_name : String? = null,
    val desc : String? = null
) {
    override fun toString(): String {
        return "id = $id, " +
               "account type = $account_type, " +
               "account name = $account_name, " +
               "description = $desc"
    }
}