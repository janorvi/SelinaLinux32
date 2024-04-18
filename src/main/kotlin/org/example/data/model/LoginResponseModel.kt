package org.example.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponseModel(
    @SerializedName("code_transaction") var codeTransaction : String? = null,
    @SerializedName("data") var data : Data?   = Data()
)

data class Data (
    @SerializedName("token" ) var accessToken : String? = null,
    @SerializedName("token_type"   ) var tokenType   : String? = null,
    @SerializedName("user"         ) var user        : User?   = User()
)

data class User (
    @SerializedName("costOfTickets") var pricesArray : ArrayList<Price>? = null,
    @SerializedName("employee_id") var employee_id  : Int? = null,
    @SerializedName("name") var name     : String? = null,
    @SerializedName("id_card") var id_card    : String? = null,
    @SerializedName("permission" ) var permission : String? = null,
    @SerializedName("vehicle" ) var vehicle : String? = null,
    @SerializedName("internal_num") var internalNumber : String? = null
)

data class Price (
    @SerializedName("price") var price : String? = null
)