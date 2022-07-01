package com.veryable.android.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Account (
    @Expose
    @SerializedName("id")
    val id : String? = null,

    @Expose
    @SerializedName("account_type")
    val accountType : String? = null,

    @Expose
    @SerializedName("account_name")
    val accountName : String? = null,

    @Expose
    @SerializedName("desc")
    val description : String? = null
) {
    override fun toString(): String {
        return "id = $id, " +
                "account type = $accountType, " +
                "account name = $accountName, " +
                "description = $description"
    }
}