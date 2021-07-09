package com.seller.catterpiller.repositories

import androidx.lifecycle.MutableLiveData
import com.seller.catterpiller.network.MyApi
import com.seller.catterpiller.network.response.AuthResponse
import retrofit2.Response
import java.net.ResponseCache

class UserRepository {

    suspend fun addnewuser(urlrequest: String):Response<AuthResponse>{
        var response:String?=urlrequest

        return MyApi().addUsersInfo(response)
    }

}