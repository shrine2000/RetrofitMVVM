package app.tamasha.live.model

import com.google.gson.annotations.SerializedName

data class UserList(
    @SerializedName("status") var status: String? = null,
    @SerializedName("data") var data: ArrayList<User> = arrayListOf(),
    @SerializedName("message") var message: String? = null
)